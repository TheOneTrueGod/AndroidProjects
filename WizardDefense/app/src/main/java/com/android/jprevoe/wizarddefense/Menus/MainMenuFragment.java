package com.android.jprevoe.wizarddefense.Menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.jprevoe.wizarddefense.Battle.Battle;
import com.android.jprevoe.wizarddefense.BattleActivity;
import com.android.jprevoe.wizarddefense.R;

/**
 * Created by jprevoe on 5/1/15.
 */
public class MainMenuFragment extends Fragment {
    public static MainMenuFragment newInstance() {
        return new MainMenuFragment();
    }
    private Battle mBattle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        final View mainContainer = inflater.inflate(R.layout.main_menu_view, container, false);

        Button newGameButton = ((Button)mainContainer.findViewById(R.id.new_game_button));
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainContainer.getContext(), BattleActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        return mainContainer;
    }
}
