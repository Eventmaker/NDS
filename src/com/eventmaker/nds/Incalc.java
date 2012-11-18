package com.eventmaker.nds;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Incalc extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.outc);

		EditText persentEdit = (EditText) findViewById(R.id.editText2);
		SharedPreferences settings = getPreferences(0);
		String persent = settings.getString("Persent", "");
		persentEdit.setText(persent);

	}

	public void bOutClk(View v) {
		EditText Sum = (EditText) findViewById(R.id.editText1);
		EditText Persent = (EditText) findViewById(R.id.editText2);
		TextView sumwith = (TextView) findViewById(R.id.textView6);
		TextView pers = (TextView) findViewById(R.id.textView7);
		TextView nds = (TextView) findViewById(R.id.textView8);
		TextView sumwithout = (TextView) findViewById(R.id.textView9);

		String s = Sum.getText().toString();
		sumwith.setText(s);

		String p = Persent.getText().toString();
		pers.setText(p);
		Float nd = Float.parseFloat(Sum.getText().toString())
				/ (100 + Float.parseFloat(Persent.getText().toString()))
				* Float.parseFloat(Persent.getText().toString());
		nd = nd * 100;
		Integer f = nd.intValue();
		nd = f.floatValue();
		nd = nd / 100;
		nds.setText(nd.toString());
		Float snd = Float.parseFloat(Sum.getText().toString())
				/ (100 + Float.parseFloat(Persent.getText().toString())) * 100;
		snd = snd * 100;
		Integer g = snd.intValue();
		snd = g.floatValue();
		snd = snd / 100;
		sumwithout.setText(snd.toString());
	}
	@Override
    protected void onStop(){
       super.onStop();
       EditText persentEdit = (EditText) findViewById(R.id.editText2);
       
       String persent = persentEdit.getText().toString().trim(); 
       SharedPreferences settings = getPreferences(0);
       SharedPreferences.Editor editor = settings.edit();
       editor.putString("Persent", persent);     
       editor.commit();
    }
	
}
