package com.walter.app008;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ListView;

public class UsersActivity extends Activity {
    ListView list;
    ArrayList<Person> data;
    CustomAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_users);
		list=(ListView) findViewById(R.id.users_list);
		Database db=new Database(this);
		data= db.fetch();
		adapter=new CustomAdapter(this, data);
		list.setAdapter(adapter);
		list.setOnCreateContextMenuListener(this);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.users, menu);
		return true;
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {
		  menu.add("Share");
		  menu.add("Delete");
		  menu.add("View Details");
		  menu.setHeaderTitle("Select Action");
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	
	
	
	
	
	
	
	
	

}
