package com.andro.innobuzz

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.andro.innobuzz.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val TAG = "MainACtivity"
    lateinit var mainBinding: ActivityMainBinding
    var name="hello"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)


        mainBinding.whats.setOnClickListener {
            Global.makeToast(this,"Turn On Accessibility For InnoBuz")
            startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
        }
    }

}