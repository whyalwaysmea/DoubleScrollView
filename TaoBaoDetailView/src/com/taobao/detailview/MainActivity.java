package com.taobao.detailview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.scrollview).setOnClickListener(this);
		findViewById(R.id.scrollview_listview).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.scrollview:
			startActivity(new Intent(this, Activity_ScrollView.class));
			break;
		case R.id.scrollview_listview:
			startActivity(new Intent(this, Activity_ScrollView_ListView.class));
			break;
		}
	}
}
