package com.android.jprevoe.wizarddefense.Grid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Grid.Structures.CastleGrass;
import com.android.jprevoe.wizarddefense.Grid.Structures.CastleHeart;
import com.android.jprevoe.wizarddefense.Grid.Structures.CastleMoat;
import com.android.jprevoe.wizarddefense.Grid.Structures.CastleWall;
import com.android.jprevoe.wizarddefense.Grid.Structures.GridStructure;
import com.android.jprevoe.wizarddefense.Grid.Structures.Road;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by jprevoe on 7/26/15.
 */
public class BattleGrid {
    public enum GridStructureEffect {
        DAMAGE,
        WALKEDON
    }

    public static float DEFAULT_SQUARE_SIZE_X = 48; // 32
    public static float DEFAULT_SQUARE_SIZE_Y = 48; // 32

    public static float SQUARESIZE_X = 0; // Set later
    public static float SQUARESIZE_Y = 0;

    public static float GRIDSIZE_Y = 8; // 11
    public static float GRIDSIZE_X = 7; // 11
    public static float DPI = 1;

    private static BattleGrid mBattleGrid;

    private final int mSizeX;
    private final int mSizeY;
    private Grid mGrid;

    private ArrayDeque<CastleHeart> mHearts;

    private Canvas mDrawingCanvas;
    private Bitmap mDrawingBitmap;
    private Vector<Position> mInvalidatedSquares;

    public static BattleGrid GetBattleGrid() {
        if (mBattleGrid == null) {
            mBattleGrid = new BattleGrid();
        }
        return mBattleGrid;
    }

    public static void onDestroy() {
        mBattleGrid = null;
    }

    public static void SetDPI(float dpi) {
        SQUARESIZE_X = (int)Math.floor(DEFAULT_SQUARE_SIZE_X * dpi);
        SQUARESIZE_Y = (int)Math.floor(DEFAULT_SQUARE_SIZE_Y * dpi);
        DPI = dpi;
    }

    private BattleGrid() {
        mSizeX = (int)GRIDSIZE_X;
        mSizeY = (int)GRIDSIZE_Y;
        mGrid = new Grid(mSizeX, mSizeY);
        mDrawingBitmap = Bitmap.createBitmap(
                (int) (mSizeX * SQUARESIZE_X), (int)(mSizeY * SQUARESIZE_Y),
                Bitmap.Config.ARGB_8888);
        mDrawingCanvas = new Canvas(mDrawingBitmap);
        mInvalidatedSquares = new Vector<Position>();

        mHearts = new ArrayDeque<>();

        for (int x = 0; x < mSizeX; x++) {
            if (x == mSizeX / 2) {
                setCastleHeart(x, mSizeY - 1);
            } else {
                setGridStructure(x, mSizeY - 1, new CastleWall());
            }
            setGridStructure(x, mSizeY - 2, new CastleWall());
            if (x != mSizeX / 2 && x != mSizeX / 2 - 1 && x != mSizeX / 2 + 1) {
                setGridStructure(x, mSizeY - 3, new CastleMoat());
            } else {
                for (int j = 0; j < mSizeY - 2; j++) {
                    setGridStructure(x, j, new Road());
                }
            }
            for (int y = 0; y < mSizeY; y++) {
                if (getGridSquare(x, y).getGridStructure() == null) {
                    setGridStructure(x, y, new CastleGrass());
                }
            }
        }
    }

    private void setCastleHeart(int x, int y) {
        CastleHeart heart = new CastleHeart(x, y);
        setGridStructure(x, y, heart);
        mHearts.push(heart);
    }

    public void setGridStructure(int x, int y, GridStructure gridStructure) {
        if (gridStructure == null) {
            gridStructure = new Road();
        }

        getGridSquare(x, y).setGridStructure(gridStructure);
        mInvalidatedSquares.add(Position.create(x, y));
    }

    public void addPlayer(Player player) {
        for (CastleHeart heart : mHearts) {
            heart.setLinkedUnit(player);
        }
    }

    public void applyStructureEffect(int x, int y, GridStructureEffect effect, float amount) {
        Grid.GridColumn.GridSquare gridSquare = getGridSquare(x, y);
        GridStructure gridStructure = gridSquare.getGridStructure();
        gridStructure.applyStructureEffect(effect, amount);
        if (gridStructure.ReadyToDestroy()) {
            setGridStructure(x, y, gridStructure.getStructureUnderneath());
        }
        else if (gridStructure.isInvalidated()) {
            mInvalidatedSquares.add(Position.create(x, y));
        }
    }

    public void addObjectToGrid(Object gridObject, Position position) {
        getGridSquare(position.x, position.y).addGridObject(gridObject);
    }

    public void removeObjectFromGrid(Object gridObject, Position position) {
        getGridSquare(position.x, position.y).removeGridObject(gridObject);
    }

    public Grid.GridColumn.GridSquare getGridSquare(float posX, float posY) {
        return getGridSquare((int)posX, (int)posY);
    }

    public Grid.GridColumn.GridSquare getGridSquare(int posX, int posY) {
        if (0 <= posX && posX < mSizeX &&
            0 <= posY && posY < mSizeY) {
            return mGrid.getGridColumn(posX).getGridSquare(posY);
        }
        return null;
    }

    public void drawOnCanvas(Canvas canvas, Context context) {
        for (Position position : mInvalidatedSquares) {
            getGridSquare(position.x, position.y).drawOnCanvas(
                    mDrawingCanvas, context);
        }
        canvas.drawBitmap(mDrawingBitmap, 0, 0, null);
    }

    public int getSizeX() {
        return mSizeX;
    }

    public int getSizeY() {
        return mSizeY;
    }

    public class Grid {
        private List<GridColumn> mGridColumns;

        private Grid(int columnsPerRow, int squaresPerColumn) {
            mGridColumns = new ArrayList<GridColumn>();
            for (int i = 0; i < columnsPerRow; i++) {
                mGridColumns.add(new GridColumn(squaresPerColumn, i));
            }
        }

        public GridColumn getGridColumn(int index) {
            return mGridColumns.get(index);
        }

        public class GridColumn {
            private final int mColumnIndex;
            private List<GridSquare> mGridSquares;

            private GridColumn(int squaresPerColumn, int columnIndex) {
                mGridSquares = new ArrayList<GridSquare>();
                mColumnIndex = columnIndex;
                for (int i = 0; i < squaresPerColumn; i++) {
                    mGridSquares.add(new GridSquare(Position.create(mColumnIndex, i)));
                }
            }

            public GridSquare getGridSquare(int index) {
                return mGridSquares.get(index);
            }

            public class GridSquare {
                private List<Object> mGridObjects;
                private GridStructure mGridStructure;
                private Position mPosition;

                private GridSquare(Position position) {
                    mGridObjects = new ArrayList<Object>();
                    mPosition = position;
                }

                public List<Object> getGridObjects() {
                    return mGridObjects;
                }

                private void addGridObject(Object gridObject) {
                    mGridObjects.add(gridObject);
                }

                private void removeGridObject(Object gridObject) {
                    mGridObjects.remove(gridObject);
                }

                public GridStructure getGridStructure() {
                    return mGridStructure;
                }

                private void setGridStructure(GridStructure gridStructure) {
                    mGridStructure = gridStructure;
                }

                public void drawOnCanvas(Canvas canvas, Context context) {
                    if (mGridStructure != null) {
                        mGridStructure.drawOnCanvas(canvas, context, mPosition.x, mPosition.y);
                    } else {

                    }
                }

                public boolean protectsUnitFromAttack() {
                    if (mGridStructure == null) {
                        return false;
                    }
                    return mGridStructure.protectsUnitFromAttack();
                }

                public void unitLeaving(Unit unit) {
                    if (mGridStructure != null) {
                        mGridStructure.unitLeaving(unit);
                    }
                }

                public void unitEntering(Unit unit) {
                    if (mGridStructure != null) {
                        mGridStructure.unitEntering(unit);
                    }
                }

                public boolean isEmpty() {
                    return getGridObjects().size() == 0;
                }
            }
        }
    }

    public static Position getGridCoordinate(float x, float y) {
        return Position.create((int) (x / SQUARESIZE_X), (int) (y / SQUARESIZE_Y));
    }

    public static float getWidth() {
        return GRIDSIZE_X * SQUARESIZE_X;
    }

    public static float getHeight() {
        return GRIDSIZE_Y * SQUARESIZE_Y;
    }

    public Position getHeartPosition() {
        if (mHearts != null) {
            return mHearts.getFirst().getPosition();
        }
        return null;
    }
}
