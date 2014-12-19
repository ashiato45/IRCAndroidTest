package com.ashiato45.test2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity{
	SocketManager socketManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		socketManager = new SocketManager();

/*		TextView t = (TextView)findViewById(R.id.maintext);
		t.setText("This is Tom.");*/

		Button b = (Button)findViewById(R.id.mainButton);
		final TextView inputText = (TextView)findViewById(R.id.mainEdit);
		final TextView scroll = (TextView)findViewById(R.id.mainScroll2);
		final RelativeLayout rl = (RelativeLayout)findViewById(R.id.mainLayout);

		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ

				addAndClear();
			}
		});

		inputText.setOnKeyListener(new OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO 自動生成されたメソッド・スタブ
				if(event.getAction() == KeyEvent.ACTION_DOWN
						&& keyCode == KeyEvent.KEYCODE_ENTER){
					InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
					addAndClear();
				}
				return false;
			}
		});

	}

	protected void addAndClear(){
		TextView inputText = (TextView)findViewById(R.id.mainEdit);
		addScroll(inputText.getText().toString());
		inputText.setText("");
	}

	protected void addScroll(String message) {
		TextView scroll = (TextView)findViewById(R.id.mainScroll2);

		String current = scroll.getText().toString();
		current += "\n";
		current += message;
		scroll.setText(current);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


}
