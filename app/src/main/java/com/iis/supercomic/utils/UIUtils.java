package com.iis.supercomic.utils;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by joyworks on 2015/12/27.
 */
public class UIUtils {
    public static void startActivity(Activity activity,Class<? extends Activity> clazz){
        Intent intent = new Intent(activity,clazz);
        activity.startActivity(intent);
    }


}
