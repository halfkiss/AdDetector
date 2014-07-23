package com.baidu.adfolder;

import android.app.Activity;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class FloatFolder extends Activity {
	SharedPreferences sharedPreferences;
	private static final String PREFERENCE_KEY_SHORTCUT_EXISTS = "IsShortCutExists";
	boolean exists = false;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);
		sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		exists = sharedPreferences.getBoolean(PREFERENCE_KEY_SHORTCUT_EXISTS,
				false);
		// create shortcut
		// if first time create it
		if (!exists) {
			setUpShortCut();
		} else {
			Intent intent = new Intent(FloatFolder.this,
					FloatWindowService.class);
			startService(intent);
		}
		finish();

	}
	
	
	/*
	 * create shortcut
	 */
	private void setUpShortCut() {
		Intent shortcut = new Intent(
				"com.android.launcher.action.INSTALL_SHORTCUT");

		shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, "baiduad");

		shortcut.putExtra("duplicate", true);

		Intent shortcutIntent = new Intent(Intent.ACTION_MAIN);
		shortcutIntent.putExtra("tName", "baiduad");
		shortcutIntent.setClassName("com.baidu.adfolder",
				"com.baidu.adfolder.FloatFolder");
		shortcutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
		ShortcutIconResource iconRes = Intent.ShortcutIconResource.fromContext(
				this, R.drawable.ic_launcher);
		shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
		sendBroadcast(shortcut);
		Editor editor = sharedPreferences.edit();
		editor.putBoolean(PREFERENCE_KEY_SHORTCUT_EXISTS, true);
		editor.commit();
	}

}
