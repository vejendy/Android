package com.google.vejendy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class IntnetValueActivity extends Activity {
	Button close;
	TextView selecteditem;
	 @Override
	 	protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.intent_value);
	        close = (Button) findViewById(R.id.close);
	        selecteditem = (TextView) findViewById(R.id.selecteditem);
	        close.setOnClickListener( bclick );
	        Intent intent = getIntent();
	        String str = intent.getExtras().getString("id");
	        str += " || " + intent.getExtras().getString("name");
	        selecteditem.setText( str );
	 }
	 OnClickListener bclick = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch(v.getId()){
			case R.id.close:
				Bundle extra = new Bundle();
				Intent intent = new Intent();
				extra.putString("id", "whpark");
				extra.putString("name", "박원환");
				extra.putString("addr", "대전");
				intent.putExtras( extra );
				setResult(RESULT_OK, intent);
				finish();
				break;
			default :
				break;
			}
		}
	};
}
