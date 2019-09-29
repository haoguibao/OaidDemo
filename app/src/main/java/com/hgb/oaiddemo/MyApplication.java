package com.hgb.oaiddemo;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.bun.miitmdid.core.JLibrary;

/**
 * @author: hgb
 * @createTime: 2019/9/27
 * @description:
 * @changed by:
 */
public class MyApplication extends Application {

    private static String oaid;


    private static boolean isSupportOaid;

    public static String getOaid() {
        return oaid;
    }

    public static boolean isSupportOaid() {
        return isSupportOaid;
    }

    public static void setIsSupportOaid(boolean isSupportOaid) {
        MyApplication.isSupportOaid = isSupportOaid;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        JLibrary.InitEntry(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //获取OAID等设备标识符
        MiitHelper miitHelper = new MiitHelper(appIdsUpdater);
        miitHelper.getDeviceIds(getApplicationContext());
    }

    private MiitHelper.AppIdsUpdater appIdsUpdater = new MiitHelper.AppIdsUpdater() {
        @Override
        public void OnIdsAvalid(@NonNull String ids) {
            Log.e("++++++ids: ", ids);
            oaid = ids;
        }
    };

}
