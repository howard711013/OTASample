package com.example.extjartest;

import com.example.extjar.aidl.IExtJarTest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnClickListener {

	private JarLoader mJarLoader;
	private ResLoader mResLoader;
	private IExtJarTest mExtJar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Button bt = new Button(this);
		bt.setText("EXTJAR TEST");
		bt.setId(1);
		bt.setOnClickListener(this);
		
		Button bt2 = new Button(this);
		bt2.setId(2);
		bt2.setOnClickListener(this);
		bt2.setText("EXTRES TEST");
		
		Button bt3 = new Button(this);
		bt3.setId(3);
		bt3.setOnClickListener(this);
		bt3.setText("EXT FW INIT");
		
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.addView(bt);
		layout.addView(bt2);
		layout.addView(bt3);
		
		setContentView(layout);
		
		mJarLoader = new JarLoader(this);
		
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch(id)
		{
		case 1:
			Log.d("test","extJar = " + mExtJar.helloWord());
			break;
			
		case 2:
			Log.d("test","extRes = " + mResLoader.getString("hello"));
			break;
		case 3:
			mExtJar = mJarLoader.ExtJarInit();
			mResLoader = new ResLoader(this);
			break;


		}
		
	}
}
