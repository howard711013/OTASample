package com.example.extjartest;

import java.lang.reflect.Method;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

public class ResLoader {
	private static final String PACKAGE_NAME = "com.example.extresource";
	private static final String PATH  = "/sdcard/extResource.apk";
	
	private AssetManager mAssetManager;
	private Resources mResources;
	public ResLoader(Context context)
	{
Log.d("test","ResLoader init.");		
		try {
		    AssetManager assetManager = AssetManager.class.newInstance();
		    Method addAssetPath = assetManager.getClass().getMethod("addAssetPath", String.class);
		    addAssetPath.invoke(assetManager,PATH);
		    mAssetManager = assetManager;
		} catch (Exception e) {
			e.printStackTrace();
		}
		   
		Resources res = context.getResources();
		mResources = new Resources(mAssetManager, res.getDisplayMetrics(),res.getConfiguration());
	}
	
	public String getString(String key)
	{
		int resId = mResources.getIdentifier(key, "string", PACKAGE_NAME);
		return mResources.getString(resId);
	}
	
	public boolean getBoolean(String key)
	{
		int resId = mResources.getIdentifier(key, "bool", PACKAGE_NAME);
		return mResources.getBoolean(resId);
	}
	
	public int getInteger(String key)
	{
		int resId = mResources.getIdentifier(key, "integer", PACKAGE_NAME);
		return mResources.getInteger(resId);
	}
}
