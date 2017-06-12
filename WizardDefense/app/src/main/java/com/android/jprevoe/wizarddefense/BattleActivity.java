package com.android.jprevoe.wizarddefense;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;


public class BattleActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        BattleFragment fragment = BattleFragment.newInstance(this);
        fragment.setActivity(this);
        return fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        super.onCreate(savedInstanceState);
    }

    public void battleEnding(boolean player_won) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("player_won", player_won);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}
