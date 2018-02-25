package com.example.myshareapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	private EditText mTitle;
	private EditText mContent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTitle = findView(R.id.mTitle);
		mContent = findView(R.id.mContent);
	}

	@SuppressWarnings("unchecked")
	public <T extends View>T findView(int id) {
		return (T) findViewById(id);
	}
	
	public void share(View v){
		Intent intent=new Intent(Intent.ACTION_SEND);   
        intent.setType("text/plain");  
        intent.putExtra(Intent.EXTRA_SUBJECT, "∑÷œÌ");   
        intent.putExtra(Intent.EXTRA_TITLE, mTitle.getText().toString());  
        intent.putExtra(Intent.EXTRA_TEXT, mContent.getText().toString());  
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);   
        startActivity(Intent.createChooser(intent, "«Î—°‘Ò")); 
	}
	
}
