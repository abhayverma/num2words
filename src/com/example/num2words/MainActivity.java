package com.example.num2words;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Gravity;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		WebView browser = (WebView) findViewById(R.id.webview);
		browser.setWebViewClient(new MyBrowser());
		browser.getSettings().setJavaScriptEnabled(true);
		browser.loadUrl("file:///android_asset/num2Words.html");	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private class MyBrowser extends WebViewClient {
		   @Override
		   public boolean shouldOverrideUrlLoading(WebView view, String url) {
		      view.loadUrl(url);
		      return true;
		   }
		   @Override
		   public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
			  Toast toast = Toast.makeText(getBaseContext(), "Unable to process the request, try again later", Toast.LENGTH_LONG);	  
		      toast.setGravity(Gravity.CENTER, 0, 0);
		      toast.show();
		      finish();
			  super.onReceivedError(view, errorCode, description, failingUrl);
		   }	
		}

}
