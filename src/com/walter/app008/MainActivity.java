package com.walter.app008;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText edNames, edEmail, edAge;    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edNames=(EditText) findViewById(R.id.edtNames);
		edEmail=(EditText) findViewById(R.id.edtEmail);
		edAge=(EditText) findViewById(R.id.edtAge);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void save(View v)
	{
	  String names= edNames.getText().toString();
	  String email=edEmail.getText().toString();
	  String age=edAge.getText().toString();
	  Database db=new Database(this);
	  db.save(names, email, age);//saving
	  Toast.makeText(this, "Number is "+db.count(), Toast.LENGTH_SHORT).show();	  
	}	
	public void retrieve(View v)
	{
      Intent x=new Intent(this, UsersActivity.class);
      startActivity(x);
	}
	
	
	
	
}
