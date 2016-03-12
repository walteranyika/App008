package com.walter.app008;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class DropDownActivity extends Activity {
    Spinner courses;
    ArrayAdapter<String> adapter;
    String data[]={"Maths","English","Geography",
    		     "History","Biology","Chemistry"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drop_down);
		courses=(Spinner) findViewById(R.id.spinnerCourses);
		
		adapter=new ArrayAdapter<String>
		    (this, android.R.layout.simple_spinner_item, data);
		
		adapter.setDropDownViewResource
		     (android.R.layout.simple_spinner_dropdown_item);
		
		courses.setAdapter(adapter);
		
		courses.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				
				Toast.makeText(getApplicationContext(),
						       data[position],
						       Toast.LENGTH_SHORT).show();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.drop_down, menu);
		return true;
	}

}
