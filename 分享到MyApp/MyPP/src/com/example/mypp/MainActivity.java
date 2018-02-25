package com.example.mypp;

import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.content);
		initBundle();
		
	}
	/**
	 * ��ȡ����PP������
	 */
	private void initBundle() {
		Intent intent = getIntent();
		if(intent == null)
			return;
		Bundle extras = intent.getExtras();
		
		if(extras == null)
			return;
		
		switch (intent.getType()) {
		case "text/plain"://�������������
			tv.setText("�������ݣ�\ntitle: " + extras.get(Intent.EXTRA_TITLE) 
					+ "\ncontent: " + extras.get(Intent.EXTRA_TEXT));
			break;
		default:
			break;
		}
	}

}
