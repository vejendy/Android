package com.google.vejendy;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewActivity extends Activity {
	Button close; 
	ListView listview;
	ArrayAdapter<String> listAdapter;
	TextView selecteditem;
	TextView resulttext;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.listview_activity);
	        close = (Button) findViewById(R.id.close);
	        listview = (ListView) findViewById(R.id.listview);
	        selecteditem = (TextView) findViewById(R.id.selecteditem);
	        resulttext = (TextView) findViewById(R.id.resulttext);
	        close.setOnClickListener( bclick );
	        ArrayList<String> arraylist = new ArrayList<String>();
	        arraylist.add("HTML");
	        arraylist.add("Java");
	        arraylist.add("HTML");
	        arraylist.add("oracle");
	        arraylist.add("jQuery");
	        arraylist.add("MySQL");
	        arraylist.add("Linux");
	        arraylist.add("Unix");
	        arraylist.add("Android");
	        arraylist.add("JavaScript");
	        arraylist.add("Flex");
	        arraylist.add("C");
	        arraylist.add("Embedd");
	        arraylist.add("AT&T");
	        arraylist.add("Python");
	        arraylist.add("C++");
	        arraylist.add("C#");
	        listAdapter = new ArrayAdapter<String>(this,R.layout.listview_row,arraylist);
	        listview.setAdapter(listAdapter);
	        listview.setOnItemClickListener(itemclick);
	 }
	 AdapterView.OnItemClickListener itemclick = new AdapterView.OnItemClickListener() {
		 @Override
		 public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long position) {
					String selected = (String) arg0.getAdapter().getItem((int) position);
					selecteditem.setText(selected);
					Intent intent = new Intent( ListViewActivity.this , IntnetValueActivity.class);
					intent.putExtra("name", selected);
					intent.putExtra("id", "whpark");
					startActivityForResult(intent, 0);  //값을 가지고 갔다가 오면 onactivityresult 메소드를 자동으로 실행한다 
		 }
	 };
	 public void onActivityResult( int requestCode, int resultCode, Intent intent){
		 super.onActivityResult(requestCode, resultCode, intent);
		 if(resultCode == RESULT_OK ){
			 
			 Log.d("======>", "=====>");
			 Log.d("======>", "=====result===>");
			 Log.d("======>", "=====result===>");
			 Log.d("======>", "=====reuslt===>");
		 }
		 
	 }
	 OnClickListener bclick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch(v.getId()){
			case R.id.close:
				finish();
				break;
			default :
				break;
			}
			
		}
	};
	

}
