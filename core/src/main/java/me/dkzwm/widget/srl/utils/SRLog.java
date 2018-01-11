package me.dkzwm.widget.srl.utils;

import android.support.annotation.IntDef;
import android.util.Log;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by dkzwm on 2017/5/22.
 *
 * @author dkzwm
 */
public class SRLog {
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_WARNING = 3;

    private static int sLevel = LEVEL_VERBOSE;

    private SRLog() {
    }

    public static void setLevel(@Level int level) {
        sLevel = level;
    }

    public static void d(String tag, String msg) {
        if (sLevel > LEVEL_DEBUG) {
            return;
        }
        Log.d(tag, msg);
    }

    public static void d(String tag, String msg, Object... args) {
        if (sLevel > LEVEL_DEBUG) {
            return;
        }
        if (args.length > 0) {
            msg = String.format(msg, args);
        }
        Log.d(tag, msg);
    }

    public static void i(String tag, String msg) {
        if (sLevel > LEVEL_INFO) {
            return;
        }
        Log.i(tag, msg);
    }

    public static void i(String tag, String msg, Object... args) {
        if (sLevel > LEVEL_INFO) {
            return;
        }
        if (args.length > 0) {
            msg = String.format(msg, args);
        }
        Log.i(tag, msg);
    }

    public static void w(String tag, String msg) {
        if (sLevel > LEVEL_WARNING) {
            return;
        }
        Log.w(tag, msg);
    }


    @IntDef({LEVEL_VERBOSE, LEVEL_DEBUG, LEVEL_INFO, LEVEL_WARNING})
    @Retention(RetentionPolicy.SOURCE)
    @interface Level {
    }
}
