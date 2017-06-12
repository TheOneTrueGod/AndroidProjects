package com.android.jprevoe.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by jprevoe on 4/28/15.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
