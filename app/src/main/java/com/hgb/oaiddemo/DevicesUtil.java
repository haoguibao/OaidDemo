package com.hgb.oaiddemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.util.UUID;

/**
 * @author: hgb
 * @createTime: 2019/9/27
 * @description:
 * @changed by:
 */
public class DevicesUtil {


    /**
     * 获取唯一标识idfa
     *
     * @return
     */
    /**
     * 获取Oaid
     *
     * @return oaid或错误码
     */
    public static String getOaid() {
        String idfa;
        if (MyApplication.isSupportOaid()) {
            idfa = MyApplication.getOaid();
        } else {
            idfa = "获取失败，ErrorCode: " + MyApplication.getErrorCode();
        }
        return idfa;
    }


}
