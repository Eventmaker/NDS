package com.eventmaker.nds;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class NDSActivity extends TabActivity {
	/** Called when the activity is first created. */
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TabHost tabHost = getTabHost();
		// ��� ����������
		tabHost.getTabWidget().setDividerDrawable(R.drawable.tab_divider);
		TabSpec inc = tabHost.newTabSpec("tab1"); // ������������� ������ ����
		inc.setIndicator(createTabincView(tabHost.getContext(),"���������")); // �������� ����
		Intent incIntent = new Intent(this, Incalc.class);// ����� � ��������
																// �����
																// ����������
																// ��� ��������
		inc.setContent(incIntent);

		// ��� ���������
		TabSpec outc = tabHost.newTabSpec("tab2"); // ������������� ������ ����
		outc.setIndicator(createTaboutcView(tabHost.getContext(), "����������")); // �������� ����
		Intent outcIntent = new Intent(this, Outcalc.class);// ����� � ��������
																// �����
																// ����������
																// ��� ��������
		outc.setContent(outcIntent);

		// ��������� ��� ���� ��������� ���� � TabHost
		tabHost.addTab(inc); // ������
		tabHost.addTab(outc); // ������

	}
	private static View createTabincView(final Context context, final String text) {
		View view = LayoutInflater.from(context).inflate(R.layout.tabs_in, null);
		TextView tv = (TextView) view.findViewById(R.id.tabsText);
		tv.setText(text);
		return view;
	}
	private static View createTaboutcView(final Context context, final String text) {
		View view = LayoutInflater.from(context).inflate(R.layout.tabs_out, null);
		TextView tv = (TextView) view.findViewById(R.id.tabsText);
		tv.setText(text);
		return view;
	}
}