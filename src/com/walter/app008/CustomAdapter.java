package com.walter.app008;
//emobilis-server.com
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class CustomAdapter extends BaseAdapter {
	Context mContext;
	ArrayList<Person> data;//Changes
	public CustomAdapter(Context context, ArrayList<Person> data)//Changes 
	{
		this.mContext = context;
		this.data = data;
	}
	@Override
	public int getCount() {
		return data.size();// # of items in your arraylist
	}
	@Override
	public Object getItem(int position) {
		return data.get(position);// get the actual movie
	}
	@Override
	public long getItemId(int id) {
		return id;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			convertView = inflater.inflate(R.layout.list_item_layout, parent,false);//Changes
			viewHolder = new ViewHolder();
			viewHolder.namesTextView = (TextView) convertView.findViewById(R.id.tvNames);//Changes
			viewHolder.ageTextView = (TextView) convertView.findViewById(R.id.tvAge);//Changes
			viewHolder.emailTextView = (TextView) convertView.findViewById(R.id.tvEmail);//Changes
            //font squirrel
			
			Typeface font= Typeface.createFromAsset(mContext.getAssets(),
					                          "myfont.ttf");
			viewHolder.namesTextView.setTypeface(font);
			viewHolder.emailTextView.setTypeface(font);
			viewHolder.ageTextView.setTypeface(font);
			
			
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
        Person p = data.get(position);
        viewHolder.namesTextView.setText(p.getNames());//Changes
        viewHolder.emailTextView.setText(p.getEmail());//Changes
        viewHolder.ageTextView.setText(p.getAge());//Changes

		return convertView;
	}
	static class ViewHolder {
		//Changes
		TextView namesTextView;
		TextView emailTextView;
		TextView ageTextView;
		
	}

}



