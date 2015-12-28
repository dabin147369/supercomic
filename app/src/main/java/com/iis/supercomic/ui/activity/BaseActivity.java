package com.iis.supercomic.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;

/**
 * Created by joyworks on 2015/12/27.
 */
public class BaseActivity extends Activity {
    protected Activity mContext;
    protected LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;
        mInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
    }
}
