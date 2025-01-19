package com.example.islami.ui.activity

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.databinding.ActivityMainBinding
import com.example.islami.ui.fragments.HadithFragment
import com.example.islami.ui.fragments.QuranFragment
import com.example.islami.ui.fragments.RadioFragment
import com.example.islami.ui.fragments.SiphaFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var showSplashScreen = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        systemBars()

        setup()
    }

    private fun setup() {
        setupNavigation()
      binding.btnNav.selectedItemId = R.id.item_quran
    }

    private fun setupNavigation() {
        binding.btnNav.setOnItemSelectedListener { menuItem ->
            val fragment = when (menuItem.itemId) {
                R.id.item_quran -> {
                    QuranFragment()
                }

                R.id.item_hadith -> {
                    HadithFragment()
                }

                R.id.item_sipha -> {
                    SiphaFragment()
                }

                R.id.item_radio -> {
                    RadioFragment()
                }

                else -> QuranFragment()
            }
            showFragment(fragment)
            return@setOnItemSelectedListener true
        }
    }


    private fun showFragment(fragment: Fragment) {
        if (fragment is SiphaFragment) {
            supportFragmentManager.beginTransaction().replace(R.id.frameSiphaContainer, fragment)
                .commit()
            binding.frameContainer.visibility = View.GONE
            binding.frameSiphaContainer.visibility = View.VISIBLE
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.frameContainer, fragment)
                .commit()
            binding.frameSiphaContainer.visibility = View.GONE
            binding.frameContainer.visibility = View.VISIBLE
        }
    }


    private fun initSplashScreen() {
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { showSplashScreen }
        Handler(mainLooper).postDelayed({
            showSplashScreen = false
        }, 0)
    }

    private fun systemBars() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }
    }
}