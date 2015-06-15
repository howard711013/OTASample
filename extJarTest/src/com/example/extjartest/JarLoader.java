package com.example.extjartest;

import java.io.File;

import com.example.extjar.aidl.IExtJarTest;

import android.content.Context;
import android.util.Log;
import dalvik.system.DexClassLoader;

public class JarLoader {

	private DexClassLoader mDexLoader;
	
	private Context mContext;
	public JarLoader(Context context)
	{
		mContext = context;
	}
    
	
	public IExtJarTest ExtJarInit()
	{
Log.d("test","JarLoader init");		
		init();
		try {
			Class<?> clazz = mDexLoader.loadClass("com.example.extjar.ExtJarTest");
			return (IExtJarTest) clazz.newInstance();
			
		} catch (Exception e) {
		}
		return null;
	}
	
    private void init()
    {
        File jar = new File("/sdcard/ExtJarTest_dex.jar");

        String dexSourceDir = jar.getAbsolutePath();
        String dexOutputDir = mContext.getApplicationContext().getDir("dex", 0).toString();
        String dexLibDir = null;
        ClassLoader loader = this.getClass().getClassLoader();
        mDexLoader = new DexClassLoader(dexSourceDir,dexOutputDir,dexLibDir,loader);
    }
    
}
