package com.taobao.detailview;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.taobao.detailview.TBLayout.OnPageChangedListener;
import com.taobao.detailview.TBLayout.OnPullListener;

public class Activity_ScrollView_ListView extends Activity implements
		OnPullListener, OnPageChangedListener {
	private TBLayout mLayout;
	private ScrollView mHeader;
	private ListView mFooter;
	private LinearLayout mHeaderContent;
	private ArrayAdapter<String> adapter;
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scrollview_listview);
		mLayout = (TBLayout) findViewById(R.id.tblayout);
		mLayout.setOnPullListener(this);
		mLayout.setOnContentChangeListener(this);
		mHeader = (ScrollView) findViewById(R.id.header);
		mFooter = (ListView) findViewById(R.id.footer);
		tv = new TextView(this);
		tv.setText("test");
		tv.setTextSize(100);
		mFooter.addHeaderView(tv);
		mHeaderContent = (LinearLayout) mHeader.getChildAt(0);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1);
		for (int i = 0; i < 24; i++) {
			adapter.add("Item--------" + i);
		}
		mFooter.setAdapter(adapter);
	}

	@Override
	public boolean headerFootReached(MotionEvent event) {
		System.out.println("KK"+tv.getScrollY());
		if (mHeader.getScrollY() + mHeader.getHeight() >= mHeaderContent
				.getHeight()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean footerHeadReached(MotionEvent event) {
		System.out.println(mFooter.getScrollY());
		if (mFooter.getFirstVisiblePosition() == 0) {
			View v = mFooter.getChildAt(0);
			if (v != null && v.getTop() == 0) {
				return true;
			}
		}
//		System.out.println(tv.getScrollY());
//		if (tv.getScrollY() == 0) {
//			return true;
//			
//		}
		return false;
	}

	@Override
	public void onPageChanged(int stub) {
	}
}
