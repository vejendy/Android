package com.google.vejendy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends Activity {
	EditText id;
	EditText name;
	InputMethodManager imm;
	Button btn1; Button btn2;
	LinearLayout baselayout;
	ImageView imgview1;ImageView listview;
	RadioGroup gender;
	RadioButton male;
	RadioButton malefemale;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Log.d("------>>", "----->>");
        setContentView(R.layout.activity_main);
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        baselayout = (LinearLayout) findViewById(R.id.baselayout);
        id = (EditText) findViewById(R.id.id);
        name = (EditText) findViewById(R.id.name);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        imgview1 = (ImageView) findViewById(R.id.imgview1);
        listview = (ImageView) findViewById(R.id.listview);
        btn1.setOnClickListener(bClick);
        btn2.setOnClickListener(bClick);
        baselayout.setOnClickListener( bClick );
        imgview1.setOnTouchListener( touch );
        listview.setOnTouchListener( touch );
        gender = (RadioGroup) findViewById(R.id.gender);
        male = (RadioButton) findViewById(R.id.male);
        male.setChecked(true);
//        btn.setOnClickListener( new Button.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				Log.d("", "click.......");
//				
//			}
//        	
//        });
//        Toast.makeText(MainActivity.this, "hello world", Toast.LENGTH_LONG).show();
    }
    OnTouchListener touch = new OnTouchListener () {
    	
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			switch (v.getId()) { 
			case R.id.imgview1:
				if(event.getAction()==MotionEvent.ACTION_DOWN){
					imgview1.setPadding(2, 2, 2, 2);
					imgview1.setColorFilter(111111,Mode.SRC_OVER);
				} else if(event.getAction()==MotionEvent.ACTION_UP) {
					imgview1.setPadding(0, 0, 0, 0);
					imgview1.setColorFilter(111111, Mode.SRC_OVER);
					Intent intent = new Intent(MainActivity.this , IntentActivity.class);
					startActivity(intent);
				}
				break;
			case R.id.listview:
				if(event.getAction()==MotionEvent.ACTION_DOWN){
					listview.setPadding(2, 2, 2, 2);
					listview.setColorFilter(111111,Mode.SRC_OVER);
				} else if(event.getAction()==MotionEvent.ACTION_UP) {
					listview.setPadding(0, 0, 0, 0);
					listview.setColorFilter(111111, Mode.SRC_OVER);
					Intent intent = new Intent(MainActivity.this , ListViewActivity.class);
					startActivity(intent);
				}
				break;
			default:
				break;
			}
				return true;
		}
    };
    
    Button.OnClickListener bClick = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
			switch (v.getId()) {
			case R.id.btn1:
				id.setText("button 1");
				malefemale = (RadioButton) findViewById(gender.getCheckedRadioButtonId());
				String strgender = malefemale.getText().toString();
				id.setText(strgender);
				break;
			case R.id.btn2:
				malefemale = (RadioButton) findViewById(gender.getCheckedRadioButtonId());
				String gender = malefemale.getText().toString();
				Intent intent = new Intent(MainActivity.this , MemberInsertActivity.class);
				intent.putExtra("id", id.getText().toString());
				intent.putExtra("name", name.getText().toString());
				if( gender.equals("Male")){
					intent.putExtra("malefemale", "남자");
				} else {
					intent.putExtra("malefemale", "여자");	
				}
				startActivityForResult(intent, 0);
				break;
			default:
				break;
			}
		}
	};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
