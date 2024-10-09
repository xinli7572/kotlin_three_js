package com.example.kotlin_three_js

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var myWebView: WebView

        myWebView = findViewById(R.id.web)

        myWebView.webViewClient = WebViewClient()
        var local_page_index = "http://localhost:8084/three_js/index.html";
        myWebView.loadUrl(local_page_index);
        myWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);

        var webSettings: WebSettings = myWebView.settings

        //Javascript
        webSettings.javaScriptEnabled = true
        webSettings.allowFileAccess = true

        webSettings.builtInZoomControls = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE
        }

        myWebView.loadUrl(local_page_index)

        webSettings.allowFileAccess = true
        webSettings.cacheMode = WebSettings.LOAD_NO_CACHE
        webSettings.domStorageEnabled = true
        webSettings.supportMultipleWindows()
        webSettings.allowContentAccess = true
        webSettings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS
        webSettings.useWideViewPort = true
        webSettings.loadWithOverviewMode = true
        webSettings.savePassword = true
        webSettings.saveFormData = true
        webSettings.javaScriptCanOpenWindowsAutomatically = true
        webSettings.loadsImagesAutomatically = true

        myWebView.setWebChromeClient(WebChromeClient())

    }
}