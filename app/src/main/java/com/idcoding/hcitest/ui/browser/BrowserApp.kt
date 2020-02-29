package com.idcoding.hcitest.ui.browser

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.idcoding.hcitest.R
import kotlinx.android.synthetic.main.app_browser.*

class BrowserApp : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_browser)

        val link = intent.getStringExtra("link")

        webView.settings.javaScriptEnabled = true
        webView.overScrollMode = WebView.OVER_SCROLL_NEVER
        webView.webViewClient = object : WebViewClient() {

            override fun onPageFinished(view: WebView?, url: String?) {
                progressBar.visibility = View.GONE
            }
        }
        webView.loadUrl(link)
        initToolbar()
    }

    private fun initToolbar() {
        setSupportActionBar(toolbarWeb)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home ->{
            finish()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }


}
