package com.baidu.adfolder;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
public class FloatWindow extends LinearLayout  {

	public static int viewWidth;
	public static int viewHeight;
	private GridView appWall;
	private Context mContext;
	public FloatWindow(final Context context) {
		super(context);
		LayoutInflater.from(context).inflate(R.layout.float_folder, this);
		View view = findViewById(R.id.big_window_layout);
		viewWidth = view.getLayoutParams().width;
		viewHeight = view.getLayoutParams().height;
		Button close = (Button) findViewById(R.id.finishBtn);
		close.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// close float window，stop service.
				MyWindowManager.removeBigWindow(context);
				Intent intent = new Intent(getContext(), FloatWindowService.class);
				context.stopService(intent);
			}
		});
		appWall = (GridView) findViewById(R.id.app_wall);
		List<AppInfo> apps = getAllInstalledSysApps(context);
		AppWallAdapter adapter = new AppWallAdapter(context, 0, apps, appWall);
		appWall.setAdapter(adapter);
		appWall.setOnItemClickListener(new ItemClickListener() );
		appWall.setOnItemLongClickListener(new ItemLongClickListener());
	}
	
	/**
	 * @param context
	 * @return All none system Appinfo
	 * 
	 */
	public static List<AppInfo> getAllInstalledSysApps(Context context) {
		List<AppInfo> appList = new ArrayList<AppInfo>();
		PackageManager packageManager = context.getPackageManager();
		List<PackageInfo> packlist = packageManager.getInstalledPackages(0);
		for (int i = 0; i < packlist.size(); i++) {
			ApplicationInfo appInfo = packlist.get(i).applicationInfo;
			if ((appInfo.flags & ApplicationInfo.FLAG_SYSTEM) <= 0) {
				AppInfo info = new AppInfo();
				info.setIcon(appInfo.loadIcon(packageManager));
				info.setName((String) appInfo.loadLabel(packageManager));
				info.setPackgeName(appInfo.packageName);
				appList.add(info);
			}
		}
		return appList;
	}
	
	class ItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class ItemLongClickListener implements OnItemLongClickListener{

		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view,
				int position, long id) {
			// TODO Auto-generated method stub
			return false;
		}
		
	}

	
}
