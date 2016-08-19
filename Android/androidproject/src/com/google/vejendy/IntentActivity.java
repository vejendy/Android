package com.google.vejendy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

public class IntentActivity extends Activity {
	Button close; Button naver; WebView webview; Button google; Button daum; 
	final Context context = this;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.intent_activity);
	        close = (Button) findViewById(R.id.close);
	        naver = (Button) findViewById(R.id.naver);
	        google = (Button) findViewById(R.id.google);
	        daum = (Button) findViewById(R.id.daum);
	        webview = (WebView) findViewById(R.id.webview);
	        close.setOnClickListener( bclick );
	        naver.setOnClickListener( bclick );
	        google.setOnClickListener( bclick );
	        daum.setOnClickListener( bclick );
	 }
	 OnClickListener bclick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch(v.getId()){
			case R.id.close:
				AlertDialog.Builder dialog = new AlertDialog.Builder(context);
				dialog.setMessage("Are you sure?");
				dialog.setTitle("Exit");
				dialog.setPositiveButton("no", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				});
				dialog.setNegativeButton("yes", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						finish();
					}
				});
				dialog.create();
				dialog.show();
				break;
				
//				AlertDialog.Builder alert = new AlertDialog.Builder(context);
//				alert
//				.setTitle("This is title")
//				.setMessage("Are you sure?")
//				.setIcon(R.drawable.iconimg)
//				.setNegativeButton("no", new DialogInterface.OnClickListener() {
//
//					@Override
//					public void onClick(DialogInterface dialog, int which) {
//						return;						
//					}
//					
//				})
//				.setPositiveButton("yes", new DialogInterface.OnClickListener(){
//
//					@Override
//					public void onClick(DialogInterface dialog, int which) {
//						finish();
//						
//					}
//					
//				}); 
//				
//				AlertDialog alertdialog = alert.create();
//				alertdialog.show();
//				break;
			case R.id.naver:
				webview.loadUrl("http://www.naver.com");
				break;
			case R.id.google:
				webview.loadUrl("http://www.google.com");
				break;
			case R.id.daum:
				webview.loadUrl("http://www.daum.net");
				break;
			default :
				break;
			}
			
		}
	};
	
	@Override
	public void onStart() {
		super.onDestroy();
		Log.d("======>", "Start......");
	}
	@Override
	public void onResume() {
		super.onResume();
		Log.d("======>", "Resume......");
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("======>", "destroy......");
	}
}
