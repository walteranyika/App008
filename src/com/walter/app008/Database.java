package com.walter.app008;
import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

	public Database(Context context) {
		super(context, "walter", null, 1);//modify here
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
	  //modify this query to create your own table
		String sql = "CREATE TABLE IF NOT EXISTS users "+
					"(id INTEGER PRIMARY KEY AUTOINCREMENT,"+ 
					" names TEXT NOT NULL, " +		
					" email TEXT NOT NULL," +				
					" age TEXT NOT NULL)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql="DROP TABLE IF EXISTS users";//modify to suit your table
		db.execSQL(sql);		
	}
   	/**
	 * Saves an item into sqlite database
	 */
	public void save(String names,String email, String age)//Modify here to suit what you want to save
	{
	  SQLiteDatabase db=this.getWritableDatabase();
	  ContentValues values=new ContentValues();
	  values.put("names", names);//modify here
	  values.put("email", email);//modify here
	  values.put("age", age);//modify here
	  db.insert("users", null, values);//modify here
	  db.close();
	}
	/**
	 * Fetches all  records from the database
	 */
	public ArrayList<Person> fetch()////modify here
	{
		ArrayList<Person> data=new ArrayList<Person>();////modify here
		SQLiteDatabase db=this.getReadableDatabase();
		String sql="SELECT * FROM users";//modify here to reflect your table
		Cursor cursor= db.rawQuery(sql, null);
		if(cursor.moveToFirst())
		{
		  do
		  {
			String id=cursor.getString(0);
			String names= cursor.getString(1);
			String email= cursor.getString(2);
			String age= cursor.getString(3);
			Person p=new Person(id, names, email, age);
			data.add(p);				  
		  }while(cursor.moveToNext());	//modify here
		}
		return data;
	}
	/**
	 * Counts All  Records in sqlite
	 * @return
	 */
	public int count()
	{
		SQLiteDatabase db=this.getReadableDatabase();
		String sql="SELECT * FROM users";//modify here
		Cursor cursor =db.rawQuery(sql, null);		
		return cursor.getCount();
	}
	
}
