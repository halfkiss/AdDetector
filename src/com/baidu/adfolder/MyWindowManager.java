package com.baidu.adfolder;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

public class MyWindowManager {

	private static FloatWindow mWindow;

	private static LayoutParams mWindowParams;

	private static WindowManager mWindowManager;

	/**
	 * create a float window
	 * 
	 * @param context
	 *            must be the application's Context.
	 */
	public static void createBigWindow(Context context) {
		WindowManager windowManager = getWindowManager(context);
		int screenWidth = windowManager.getDefaultDisplay().getWidth();
		int screenHeight = windowManager.getDefaultDisplay().getHeight();
		if (mWindow == null) {
			mWindow = new FloatWindow(context);
			if (mWindowParams == null) {
				mWindowParams = new LayoutParams();
				mWindowParams.x = screenWidth / 2 - FloatWindow.viewWidth / 2;
				mWindowParams.y = screenHeight / 2 - FloatWindow.viewHeight / 2;
				mWindowParams.type = LayoutParams.TYPE_PHONE;
				mWindowParams.format = PixelFormat.RGBA_8888;
				mWindowParams.gravity = Gravity.LEFT | Gravity.TOP;
				mWindowParams.width = FloatWindow.viewWidth;
				mWindowParams.height = FloatWindow.viewHeight;
			}
			windowManager.addView(mWindow, mWindowParams);
		}
	}

	/**
	 * remove the float window from screen
	 * 
	 * @param context
	 *            must be the application's Context.
	 */
	public static void removeBigWindow(Context context) {
		if (mWindow != null) {
			WindowManager windowManager = getWindowManager(context);
			windowManager.removeView(mWindow);
			mWindow = null;
		}
	}

	/**
	 * is the float window on the desktop
	 * 
	 * @return yet for true.
	 */
	public static boolean isWindowShowing() {
		return mWindow != null;
	}

	/**
	 *  WindowManager。
	 * 
	 * @param context
	 *            must be the application's Context.
	 * @return WindowManager use to control the float window
	 */
	private static WindowManager getWindowManager(Context context) {
		if (mWindowManager == null) {
			mWindowManager = (WindowManager) context
					.getSystemService(Context.WINDOW_SERVICE);
		}
		return mWindowManager;
	}

}
