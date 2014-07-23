package com.baidu.adfolder;

import java.util.List;

import android.graphics.drawable.Drawable;


public class AppInfo {
	
	private Drawable icon;
	private String name;
	private String packgeName;
	private List<String> adList;
	
	public List<String> getAdList() {
		return adList;
	}
	public void setAdList(List<String> adList) {
		this.adList = adList;
	}
	public Drawable getIcon() {
		return icon;
	}
	public void setIcon(Drawable icon) {
		this.icon = icon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPackgeName() {
		return packgeName;
	}
	public void setPackgeName(String packgeName) {
		this.packgeName = packgeName;
	}
	
}
