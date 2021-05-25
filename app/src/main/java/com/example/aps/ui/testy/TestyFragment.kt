package com.example.aps.ui.testy

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.aps.R
import com.example.aps.functions.CustomEvent
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.ViewModelProvider
import com.example.aps.MainActivity
import com.jaeger.library.StatusBarUtil


class TestyFragment : Fragment() {

  private lateinit var testyViewModel: TestyViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    testyViewModel =
    ViewModelProvider(this).get(TestyViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_testy, container, false)

    return root
  }

}