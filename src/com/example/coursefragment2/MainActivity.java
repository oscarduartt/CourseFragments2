package com.example.coursefragment2;

import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity implements FragmentManager.OnBackStackChangedListener{

	final String FRAGMENTTAG = "DinamicFragment";
	final static public String LOGTAG = "FragmentTransition";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FragmentManager fm = getFragmentManager();
		fm.addOnBackStackChangedListener(this);
	}

	//Añade un fragmneto nuevo a un contenedor
	public void onClickBtnAdd(View v) {
		Log.i(LOGTAG, "onClickBtnAdd");
		Fragment1 fragment1 = new Fragment1();
		FragmentManager fm = getFragmentManager();

		FragmentTransaction ft = fm.beginTransaction();
		ft.add(R.id.group1, fragment1, FRAGMENTTAG);
		ft.addToBackStack("Add");
		ft.commit();
	}

	//Remueve un fragmento existente y añade un nuevo fragmento
	public void onClickBtnRemove(View v) {
		Log.i(LOGTAG, "onClickBtnRemove");

		FragmentManager fm = getFragmentManager();

		Fragment oldFragment = fm.findFragmentByTag(FRAGMENTTAG);
		FragmentTransaction ft = fm.beginTransaction();

		if (oldFragment != null) {
			ft.remove(oldFragment);
		}
		Fragment2 newFragment = new Fragment2();
		ft.add(R.id.group1, newFragment, "FRAGMENTTAG");
		ft.addToBackStack("Remove");
		ft.commit();

	}

	//Remplaza un fragmento existente con otro nuevo
	public void onClickBtnReplace(View v) {
		Log.i(LOGTAG, "onClickBtnReplace");

		FragmentManager fm = getFragmentManager();
		Fragment1 fragment1 = new Fragment1();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(R.id.group1, fragment1, FRAGMENTTAG);
		ft.addToBackStack("Replace");
		ft.commit();
	}

	//Recrea un fragmento destruido temporalmente en Detach
	public void onClickBtnAttach(View v) {
		Log.i(LOGTAG, "onClickBtnAttach");

		FragmentManager fm = getFragmentManager();
		Fragment fragment = fm.findFragmentByTag(FRAGMENTTAG);

		if (fragment != null) {
			FragmentTransaction ft = fm.beginTransaction();
			ft.attach(fragment);
			ft.addToBackStack("Attach");
			ft.commit();
		}
	}

	//Destruye un fragmento temporalmente; es decir, destruye la vista pero sigue activo, pudiendo recrearla
	public void onClickBtnDetach(View v) {
		Log.i(LOGTAG, "onClickBtnDetach");

		FragmentManager fm = getFragmentManager();
		Fragment fragment = fm.findFragmentByTag(FRAGMENTTAG);

		if (fragment != null) {
			FragmentTransaction ft = fm.beginTransaction();
			ft.detach(fragment);
			ft.addToBackStack("Detachjj");
			ft.commit();
		}
	}
	
	public void onClickBtnPrevious(View v){
		Log.i(LOGTAG, "onClickBtnPrevious");
		
		FragmentManager fm = getFragmentManager();
		fm.popBackStack();
	}
	
	public void showMsg(String msg){
		Log.i(LOGTAG, msg);
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}
	
	public static void LogBackStackEntry(FragmentManager.BackStackEntry entry){
		if(entry != null){
			Log.d(LOGTAG, "BackStackEntry Name: "+ entry.getName());
		}else{
			Log.d(LOGTAG, "BackStackEntry Name: <NULL>");
		}
	}

	@Override
	public void onBackStackChanged() {
		showMsg("BackStack Changed");
		Log.d(LOGTAG, "BackStack contents starting with index 0");
		FragmentManager fm = getFragmentManager();
		int backStackEntryCount = fm.getBackStackEntryCount();
		for(int i=0; i < backStackEntryCount; i++){
			LogBackStackEntry(fm.getBackStackEntryAt(i));
		}
		
	}
	
}
