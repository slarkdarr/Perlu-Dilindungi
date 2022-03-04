package com.example.perludilindungi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.net.http.*
import android.view.WindowManager
import android.webkit.SslErrorHandler
import com.example.perludilindungi.R
import com.example.perludilindungi.databinding.ActivityNewsPageBinding



class NewsPageActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private var _binding : ActivityNewsPageBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityNewsPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.newsActionBar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);

        webView = binding.newsContent

        binding.newsUrl.text = intent.getStringExtra("url")

        webView.webViewClient = object : WebViewClient() {
            override fun onReceivedSslError(
                view: WebView,
                handler: SslErrorHandler,
                error: SslError
            ) {
                handler.proceed()
            }
        }

        webView.loadUrl(intent.getStringExtra("url").toString())
    }


}