package com.example.simplecalc2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

	private EditText editText1;
	private long subtotal;
	private char op;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editText1 = (EditText) findViewById(R.id.editText1);
		editText1.setCursorVisible(false);
		editText1.clearFocus();
		onClickClear(null);
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

	public void onClickNumber(View view) {
		Button button = (Button) view;
		editText1.setText(editText1.getText().toString()
				+ button.getText().toString());
	}

	public void onClickOpration(View view) {
		long value = 0;
		if (editText1.length() > 0)
			value = Long.valueOf(editText1.getText().toString());

		editText1.setText("");
		Button button = (Button) view;
		switch (op) {
		case '\0':
			subtotal = value;
			op = button.getText().toString().charAt(0);
			break;
		case '+':
			subtotal += value;
			break;
		case '-':
			subtotal -= value;
			break;
		case '*':
			subtotal *= value;
			break;
		case '/':
			if (0 != subtotal)
				subtotal /= value;
			break;
		default:
			break;
		}

		op = button.getText().toString().charAt(0);
		if ('=' == op) {
			editText1.setText(String.valueOf(subtotal));
			op = '\0';
		}
	}

	public void onClickNeg(View v) {
		long value = (-1);
		if (editText1.length() > 0)
			value *= Long.valueOf(editText1.getText().toString());
		editText1.setText(String.valueOf(value));
	}

	public void onClickClear(View v) {
		subtotal = 0;
		editText1.setText("");
		op = '\0';
	}
}
