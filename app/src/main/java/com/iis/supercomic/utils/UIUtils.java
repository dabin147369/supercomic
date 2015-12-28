package com.iis.supercomic.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;

import com.iis.supercomic.BaseApplication;

/**
 * Created by joyworks on 2015/12/27.
 */
public class UIUtils {
    public static void startActivity(Activity activity,Class<? extends Activity> clazz){
        Intent intent = new Intent(activity,clazz);
        activity.startActivity(intent);
    }

    /**
     * 上下文
     *
     * @return
     */
    public static Context getContext()
    {
        return BaseApplication.getContext();
    }

    public static Resources getResources()
    {
        return getContext().getResources();
    }

    public static String getString(int resId)
    {
        return getResources().getString(resId);
    }

    public static String[] getStringArray(int resId)
    {
        return getResources().getStringArray(resId);
    }

    public static String getPackageName()
    {
        return getContext().getPackageName();
    }

    public static int getColor(int resId)
    {
        return getResources().getColor(resId);
    }

    public static Handler getMainHandler()
    {
        return BaseApplication.getMainHandler();
    }

    public static long getMainThreadId()
    {
        return BaseApplication.getMainThreadId();
    }

    /**
     * 让task在主线程中执行
     */
    public static void post(Runnable task)
    {
        int myTid = android.os.Process.myTid();

        if (myTid == getMainThreadId())
        {
            // 在主线程中执行的
            task.run();
        }
        else
        {
            // 在子线程中执行的
            getMainHandler().post(task);
        }
    }


    /**
     * 执行延时任务
     *
     */
    public static void postDelayed(Runnable task, int delayed)
    {
        getMainHandler().postDelayed(task, delayed);
    }

    /**
     * 移除任务
     *
     * @param task
     */
    public static void removeCallbacks(Runnable task)
    {
        getMainHandler().removeCallbacks(task);
    }


}
