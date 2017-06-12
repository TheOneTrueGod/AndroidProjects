package com.android.jprevoe.wizarddefense.Menus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Window;

import com.android.jprevoe.wizarddefense.SingleFragmentActivity;

/**
 * Created by jprevoe on 2/16/16.
 */
public class MainMenuActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return MainMenuFragment.newInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }
}
