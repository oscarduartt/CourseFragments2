package com.example.coursefragment2;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment2 extends Fragment{
final public String LOGTAG = "Fragment2";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d(LOGTAG, "onCreateView");
		View v = inflater.inflate(R.layout.fragment2, container, false);
		return v;
	}
	
	@Override
	public void onAttach(Activity activity) {
		Log.d(LOGTAG, "onAttach");
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(LOGTAG, "onCreate");
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Log.d(LOGTAG, "onActivityCreated");
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public void onStart() {
		Log.d(LOGTAG, "onStart");
		// TODO Auto-generated method stub
		super.onStart();
	}
	
	@Override
	public void onResume() {
		Log.d(LOGTAG, "onResume");
		// TODO Auto-generated method stub
		super.onResume();
	}
}
