package com.google.vejendy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MemberInsertActivity extends Activity {
	EditText id;
	EditText name;
	TextView malefemale;
	Button close;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.memberinsert);
        close = (Button) findViewById(R.id.close);
        id = (EditText) findViewById(R.id.id);
        close.setOnClickListener( bClick);
        name = (EditText) findViewById(R.id.name);
        malefemale = (TextView) findViewById(R.id.malefemale);
        Intent intent = getIntent();
        String strid = intent.getExtras().getString("id");
        String strname =intent.getExtras().getString("name");
        String strgender =intent.getExtras().getString("malefemale");
        id.setText( strid );
        name.setText( strname );
        malefemale.setText( strgender );
 }
 Button.OnClickListener bClick = new View.OnClickListener(){

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.close:
				finish();
				break;
			default:
				break;
		}
		} 
	 };
}
