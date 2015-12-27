package com.iis.supercomic.ui.activity;

import android.os.Bundle;

import com.iis.supercomic.R;
import com.iis.supercomic.constant.ConstantKey;
import com.iis.supercomic.utils.SharedPrefUtil;
import com.iis.supercomic.utils.UIUtils;


public class SplashActivity extends BaseActivity {
    private static long DURATION = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        long mCurrentTimeMillis = System.currentTimeMillis();
        try {
            Thread.sleep(DURATION);
            goHome();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void goHome(){
        long appCode = SharedPrefUtil.getInt(mContext, ConstantKey.APP_CODE, -1);
        if(appCode==-1){
            UIUtils.startActivity(mContext, GuideActivity.class);
            finish();
        }else{
            UIUtils.startActivity(mContext,HomeActivity.class);
            finish();
        }







    }


}
