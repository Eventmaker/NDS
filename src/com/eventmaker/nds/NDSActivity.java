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
		// Таб начисления
		tabHost.getTabWidget().setDividerDrawable(R.drawable.tab_divider);
		TabSpec inc = tabHost.newTabSpec("tab1"); // идентификатор нашего таба
		inc.setIndicator(createTabincView(tabHost.getContext(),"Выделение")); // Название таба
		Intent incIntent = new Intent(this, Incalc.class);// Класс к которому
																// будем
																// обращаться
																// при переходе
		inc.setContent(incIntent);

		// Таб Вычисляем
		TabSpec outc = tabHost.newTabSpec("tab2"); // идентификатор нашего таба
		outc.setIndicator(createTaboutcView(tabHost.getContext(), "Начисление")); // Название таба
		Intent outcIntent = new Intent(this, Outcalc.class);// Класс к которому
																// будем
																// обращаться
																// при переходе
		outc.setContent(outcIntent);

		// Добавляем все наши созданные табы в TabHost
		tabHost.addTab(inc); // музыка
		tabHost.addTab(outc); // фильмы

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