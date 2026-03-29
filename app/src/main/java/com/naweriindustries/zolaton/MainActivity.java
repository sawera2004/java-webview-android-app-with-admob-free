package com.naweriindustries.zolaton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        adView = findViewById(R.id.adView);

        // Load the web page in the WebView
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://huggingface.co/spaces/Sawera2004/CreaAI"); // Replace with your desired URL

        // Load AdMob banner ad
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);






    }
    //force all links to open inside thisapp

    public  boolean  shouldOverrideUrlLoading(WebView view, String url)

    {
        // Open all links from inside the WebView app
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }
}
