package com.android.jprevoe.wizarddefense.Grid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

import com.android.jprevoe.wizarddefense.Actor.UnitStats.UnitSpriteCreator;
import com.android.jprevoe.wizarddefense.R;

/**
 * Created by jprevoe on 7/26/15.
 */
public class GridDrawer {

    public static void drawImage(Canvas canvas, Bitmap image,
                                 float xPos, float yPos,
                                 Paint paint,
                                 float gridSizeX, float gridSizeY) {
        drawImage(canvas, image, xPos, yPos, paint, gridSizeX, gridSizeY, 1, 1);
    }

    public static void drawImage(Canvas canvas, Bitmap image,
                                 float xPos, float yPos,
                                 Paint paint,
                                 float gridSizeX, float gridSizeY,
                                 float scaleX, float scaleY) {
        float rectSizeX = image.getWidth();
        float rectSizeY = image.getHeight();
        float posToDrawX = xPos * gridSizeX + (gridSizeX - rectSizeX) / 2;
        float posToDrawY = yPos * gridSizeY + (gridSizeY - rectSizeY) / 2;
        canvas.save();
        if (scaleX != 1 || scaleY != 1) {
            canvas.scale(
                scaleX,
                scaleY,
                posToDrawX + image.getWidth() * Math.abs(scaleX) / 2,
                posToDrawY + image.getHeight() * Math.abs(scaleY) / 2
            );
        }

        canvas.drawBitmap(image,
                (int) posToDrawX, (int) posToDrawY,
                paint);
        canvas.restore();
    }

    public static void drawSubImage(Canvas canvas, Bitmap image,
                                 float xPos, float yPos,
                                 Paint paint,
                                 float gridSizeX, float gridSizeY,
                                 @Nullable Rect src) {
        float rectSizeX = image.getWidth();
        float rectSizeY = image.getHeight();
        float posToDrawX = xPos * gridSizeX + (gridSizeX - rectSizeX) / 2;
        float posToDrawY = yPos * gridSizeY + (gridSizeY - rectSizeY) / 2;
        canvas.drawBitmap(
            image,
            src,
            new Rect((int) posToDrawX, (int) posToDrawY,
                    (int) (posToDrawX + src.width()), (int)(posToDrawY + src.height())),
            paint
        );
    }

    public static void drawRect(Canvas canvas,
                                float xPos, float yPos,
                                Paint paint,
                                float rectSizeX, float rectSizeY,
                                float gridSizeX, float gridSizeY
    ) {
        float posToDrawX = xPos * gridSizeX + (gridSizeX - rectSizeX) / 2;
        float posToDrawY = yPos * gridSizeY + (gridSizeY - rectSizeY) / 2;

        canvas.drawRect(new Rect(
                (int)(posToDrawX),
                (int)(posToDrawY),
                (int)(posToDrawX + rectSizeX),
                (int)(posToDrawY + rectSizeY))
                , paint);
    }

    public static void drawTargettingReticule(Canvas drawingCanvas, Context context,
                                                float targetX, float targetY) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);

        float posToDrawX = targetX * BattleGrid.SQUARESIZE_X;
        float posToDrawY = targetY * BattleGrid.SQUARESIZE_Y;
        final float PADDING = 2;

        for (int i = 0; i < 2; i++) {

            switch (i) {
                case 0:
                    paint.setColor(context.getResources().getColor(R.color.white));
                    paint.setStrokeWidth(9);
                    break;
                case 1:
                    paint.setColor(context.getResources().getColor(R.color.red));
                    paint.setStrokeWidth(3);
                    break;
            }

            drawingCanvas.drawLine(posToDrawX + BattleGrid.SQUARESIZE_X / 2, posToDrawY + PADDING,
                    posToDrawX + BattleGrid.SQUARESIZE_X / 2, posToDrawY + BattleGrid.SQUARESIZE_Y - PADDING,
                    paint);

            drawingCanvas.drawLine(posToDrawX + PADDING, posToDrawY + BattleGrid.SQUARESIZE_X / 2,
                    posToDrawX + BattleGrid.SQUARESIZE_X - PADDING, posToDrawY + BattleGrid.SQUARESIZE_X / 2,
                    paint);

            drawingCanvas.drawCircle(posToDrawX + BattleGrid.SQUARESIZE_X / 2, posToDrawY + BattleGrid.SQUARESIZE_Y / 2,
                    Math.min(BattleGrid.SQUARESIZE_X / 3, BattleGrid.SQUARESIZE_Y / 3), paint);
        }
    }

    public enum TargetSeverity {
        CAUTION,
        WARNING,
        DANGER
    };

    public static void drawTarget(Canvas canvas,
                                float xPos, float yPos,
                                Paint paint,
                                float gridSizeX, float gridSizeY,
                                TargetSeverity severity
    ) {
        Bitmap bitmap;
        switch (severity) {
            case CAUTION:
                bitmap = UnitSpriteCreator.get().createFromFullImage("target_alert_3");
                break;
            case WARNING:
                bitmap = UnitSpriteCreator.get().createFromFullImage("target_alert_2");
                break;
            case DANGER:
            default:
                bitmap = UnitSpriteCreator.get().createFromFullImage("target_alert_1");
                break;

        }
        drawImage(canvas, bitmap, xPos, yPos, paint, gridSizeX, gridSizeY);
    }
}
