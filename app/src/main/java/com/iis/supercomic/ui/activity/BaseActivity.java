package com.iis.supercomic.ui.activity;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by joyworks on 2015/12/27.
 */
public class BaseActivity extends Activity {
    protected Activity mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;
    }
}
