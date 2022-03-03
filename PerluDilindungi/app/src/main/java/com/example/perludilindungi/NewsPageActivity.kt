package com.example.perludilindungi

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.perludilindungi.databinding.ActivityNewsPageBinding
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import android.net.http.*
import android.net.http.SslError

import android.webkit.SslErrorHandler
import android.R
import android.view.View


class NewsPageActivity : AppCompatActivity() {
    private var _binding : ActivityNewsPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityNewsPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.newsActionBar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.newsTitle.text = intent.getStringExtra("title")
        binding.newsPubDate.text = intent.getStringExtra("pubDate")
        binding.newsUrl.text = intent.getStringExtra("url")

        var webView: WebView = binding.newsContent

        webView.settings.javaScriptEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {

                return true
            }

            override fun onPageFinished(view: WebView, url: String) {
            }
        }

        webView.loadUrl("http://www.google.com");
    }


}