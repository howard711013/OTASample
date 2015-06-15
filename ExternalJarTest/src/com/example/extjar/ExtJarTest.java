package com.example.extjar;

import com.example.extjar.aidl.IExtJarTest;

public class ExtJarTest implements IExtJarTest{

	@Override
	public String helloWord() {
		return "=== hello TUTK ====";
		//return ResourceLoader.getResTest(context);
		//return null;
	}

}
