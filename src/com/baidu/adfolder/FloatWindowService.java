package com.baidu.adfolder;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class FloatWindowService extends Service {
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		MyWindowManager.createBigWindow(getApplicationContext());
		return super.onStartCommand(intent, flags, startId);
	}
	
	

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
