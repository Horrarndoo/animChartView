package com.zyw.horrarndoo.animtestprj.utils;

import android.util.Log;

/**
 * LogUtils
 * @author zyw
 * @creation 2016-6-16
 */
public class LogUtils {
	private static final boolean isEnableLog = true;
	/**
	 * print log error
	 * @param tag
	 * @param strContent
	 */
	public final static void error(String tag, String strContent){
		if(isEnableLog){
			Log.e(tag, strContent);
		}
	}

	/**
	 * print log info
	 * @param tag
	 * @param strContent
	 */
	public final static void info(String tag, String strContent){
		if(isEnableLog){
			Log.i(tag, strContent);
		}
	}

	/**
	 * print log warning
	 * @param tag
	 * @param strContent 
	 */
	public final static void warning(String tag, String strContent){
		if(isEnableLog){
			Log.w(tag, strContent);
		}
	}

	/**
	 * print log verbose
	 * @param tag
	 * @param strContent
	 */
	public final static void verbose(String tag, String strContent){
		if(isEnableLog){
			Log.v(tag, strContent);
		}
	}

	/**
	 * print log debug
	 * @param tag
	 * @param strContent
	 */
	public final static void debug(String tag, String strContent){
		if (isEnableLog) {			
			Log.d(tag, strContent);
		}
	}
}
