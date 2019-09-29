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
     * <p>
     * 支持获取oaid的，优先获取oaid，
     * 其次是IMEI，
     * 如果没有得到IMEI权限，则获取AndroidId
     *
     * @param context
     * @return
     */
    public static String getIdfa(Context context) {
        String idfa;
        if (MyApplication.isSupportOaid()) {
            idfa = MyApplication.getOaid();
        } else {
            idfa = getUniqueId(context);
        }
        return idfa;
    }


    /**
     * 获取唯一id
     *
     * @param context
     * @return
     */
    public static String getUniqueId(Context context) {
        String uniqueId;
        try {
            uniqueId = getIMEI(context);
        } catch (Exception e) {
            uniqueId = getAndroidId(context);
        }
        return uniqueId;
    }

    /**
     * 获取IMEI
     * 高版本需要主动申请权限
     *
     * @param context
     * @return
     */
    public static String getIMEI(Context context) {
        TelephonyManager tel = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tel.getDeviceId();
    }

    /**
     * 获取AndroidID
     *
     * @param context
     * @return
     */
    public static String getAndroidId(Context context) {
        @SuppressLint("HardwareIds")
        String androidID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return androidID;
    }


    /**
     * 获取UUID
     *
     * @return
     */
    public static String getUUID() {
        String serial;

        String m_szDevIDShort = "35" +
                Build.BOARD.length() % 10 + Build.BRAND.length() % 10 +

                Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 +

                Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 +

                Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 +

                Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 +

                Build.TAGS.length() % 10 + Build.TYPE.length() % 10 +

                Build.USER.length() % 10; //13 位

        try {
            serial = android.os.Build.class.getField("SERIAL").get(null).toString();
            //API>=9 使用serial号
            return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
        } catch (Exception exception) {
            //serial需要一个初始化
            serial = "serial"; // 随便一个初始化
        }
        //使用硬件信息拼凑出来的15位号码
        return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
    }
}
