package com.android.jprevoe.wizarddefense.Logging;

import android.os.SystemClock;
import android.util.Log;

/**
 * Created by jprevoe on 7/26/15.
 */
public class Logger {
    private static boolean WRITE_LOGS = false;
    private static String mTimerName;
    private static long mStartTime;

    public static void startTimer(String timerName) {
        mTimerName = timerName;
        mStartTime = SystemClock.elapsedRealtime();
    }

    public static void logTime(long maxTimeAllowed) {
        if (!WRITE_LOGS) {
            return;
        }
        long currTime = SystemClock.elapsedRealtime();
        long elapsedTime = currTime - mStartTime;
        String text = mTimerName.concat(" took " + String.valueOf(elapsedTime) + " milliseconds");
        if (elapsedTime > maxTimeAllowed) {
            Log.e(mTimerName, text);
        } else {
            Log.i(mTimerName, text);
        }
    }
}
