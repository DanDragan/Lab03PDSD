package com.example.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PhoneDialerActivity extends Activity {
	
	private ButtonClick bc = new ButtonClick();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phone_dialer);
		
		Button unu = (Button)findViewById(R.id.button1);
		Button doi = (Button)findViewById(R.id.button2);
		Button trei = (Button)findViewById(R.id.button3);
		Button patru = (Button)findViewById(R.id.button4);
		Button cinci = (Button)findViewById(R.id.button5);
		Button sase = (Button)findViewById(R.id.button6);
		Button sapte = (Button)findViewById(R.id.button7);
		Button opt = (Button)findViewById(R.id.button8);
		Button noua = (Button)findViewById(R.id.button9);
		Button zero = (Button)findViewById(R.id.button11);
		Button star = (Button)findViewById(R.id.button10);
		Button diez = (Button)findViewById(R.id.button12);
		
		ImageButton correct = (ImageButton)findViewById(R.id.imageButton3);
		ImageButton apel = (ImageButton)findViewById(R.id.imageButton1);
		ImageButton stop = (ImageButton)findViewById(R.id.imageButton2);
		
		unu.setOnClickListener(bc);
		doi.setOnClickListener(bc);
		trei.setOnClickListener(bc);
		patru.setOnClickListener(bc);
		cinci.setOnClickListener(bc);
		sase.setOnClickListener(bc);
		sapte.setOnClickListener(bc);
		opt.setOnClickListener(bc);
		noua.setOnClickListener(bc);
		zero.setOnClickListener(bc);
		star.setOnClickListener(bc);
		diez.setOnClickListener(bc);
		
		correct.setOnClickListener(new View.OnClickListener () {

			@Override
			public void onClick(View arg0) {
				EditText etxt = (EditText)findViewById(R.id.editText1);
				String content = etxt.getText().toString();
				etxt.setText(content.substring(0, content.length()-1));			
			}
			
		});
		
		apel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final EditText etxt = (EditText)findViewById(R.id.editText1);
				String phoneNumber = etxt.getText().toString();
				Intent intent = new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel" + phoneNumber));
				startActivity(intent);
				
			}
		});
		
		stop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.phone_dialer, menu);
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
	
	class ButtonClick implements View.OnClickListener {

		@Override
		public void onClick(View view) {
			Button b = (Button)view;
			String ch = b.getText().toString();
			EditText etxt = (EditText)findViewById(R.id.editText1);
			etxt.setText(etxt.getText() + ch);
		}		
	}
}
