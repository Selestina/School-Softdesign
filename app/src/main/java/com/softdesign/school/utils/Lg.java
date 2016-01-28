package com.softdesign.school.utils;


import android.util.Log;

/**
 * Логер использует различные уровни вывода (Verbose, debug, info, error, warn, assert).
 */
public class Lg {

    private static final String PREFIX = "SCHOOL ";
    public static final int LOGCAT_BUFFER_SIZE = 3000;

    private static boolean shouldLog() {
//        return BuildConfig.IS_LOGCAT_LOGGER_ENABLED;
        return true;
    }
/** tag - тег для лога, text - текст лога*/

    public static  void  i (String tag, String text) { assistant(Log.INFO, tag, text);}
    public static  void  v (String tag, String text) { assistant(Log.VERBOSE, tag, text);}
    public static  void  e (String tag, String text) { assistant(Log.ERROR, tag, text);}
    public static  void  w (String tag, String text) { assistant(Log.WARN, tag, text);}
    public static  void  a (String tag, String text) { assistant(Log.ASSERT, tag, text);}
    public static  void  d (String tag, String text) { assistant(Log.DEBUG, tag, text);}
    /**метод разбивает текст на несколько частей, если текст лога(кол-во символов) больше
     * чем LOGCAT_BUFFER_SIZE , записывает их (части текста) с помощью Log.println()
     * level - уровень лога */
    private static void assistant(int level, String tag, String text){
        if (shouldLog()) {
            String str = text;
            while (str.length() > LOGCAT_BUFFER_SIZE){
                Log.println(level, tag, str.substring(0, LOGCAT_BUFFER_SIZE));
                str = str.substring(LOGCAT_BUFFER_SIZE);
            }
            Log.println(level, PREFIX + tag, str);
        }
    }
}
