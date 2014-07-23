package com.baidu.adfolder;

import java.util.List;




import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.GridView;
import android.widget.TextView;

public class AppWallAdapter extends ArrayAdapter<AppInfo> implements
OnScrollListener  {
	private GridView mAppWall;
	private  List<AppInfo> mlist;
	private LayoutInflater mInflater;

	public AppWallAdapter(Context context, int textViewResourceId,
			List<AppInfo> list, GridView appWall) {
		super(context, textViewResourceId, list);
		mAppWall = appWall;
		mlist = list;
		mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mAppWall.setOnScrollListener(this);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder;
		if (convertView == null) {
			 holder = new ViewHolder();  
	            convertView = mInflater.inflate(R.layout.app_item, null);  
	            holder.icon = (ImageView) convertView.findViewById(R.id.app_icon);  
	            holder.name = (TextView) convertView  
	                    .findViewById(R.id.app_name);  
	            convertView.setTag(holder);
		} else {
			 holder = (ViewHolder) convertView.getTag();  
		}
		AppInfo info = mlist.get(position);
		holder.icon.setImageDrawable(info.getIcon());
		holder.name.setText(info.getName());
		return convertView;
	}

	
	public final class ViewHolder{
		  public ImageView icon;  
	      public TextView name;  
	}

	

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		
	}

	
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		
		
	}


}
