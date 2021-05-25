package com.example.aps.ui.teoria

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.aps.Login
import com.example.aps.MainActivity
import com.example.aps.R
import com.example.aps.functions.CustomEvent
import kotlinx.android.synthetic.main.activity_testy_temy.*


class TeoriaFragment : Fragment(), CustomEvent {

  private lateinit var teoriaViewModel: TeoriaViewModel
  private lateinit var myWebView:WebView

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    teoriaViewModel =
    ViewModelProviders.of(this).get(TeoriaViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_teoria, container, false)

    myWebView = root.findViewById<WebView>(R.id.webView)

    val wsettings: WebSettings? = myWebView.settings
    wsettings?.domStorageEnabled = true
    wsettings?.javaScriptEnabled = true

    myWebView.webViewClient = object : WebViewClient() {
      override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        Log.i("WebView", "Attempting to load URL: $url")
        view.loadUrl(url)
        return true
      }
    }
    myWebView.loadUrl("file:///android_asset/TeoriaTemy/TEORIATEMY.html")


    requireActivity()
      .onBackPressedDispatcher
      .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
          if (myWebView.canGoBack()) {
            myWebView.goBack()
          }else {
            //requireActivity().onBackPressed()
          }

        }
      }
      )


    val mainactivity = activity as MainActivity?
    mainactivity?.events?.add(0,this )

      return root

  }

  override fun DoEvent(input: String) {
    myWebView.findAllAsync(input)
  }

  override fun DoEvent2(input: String) {
    myWebView.findNext(true)
  }
  override fun DoEvent3(input: String) {
    myWebView.findNext(false)
  }
}