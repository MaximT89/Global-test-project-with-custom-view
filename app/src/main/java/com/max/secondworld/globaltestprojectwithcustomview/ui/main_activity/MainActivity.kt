package com.max.secondworld.globaltestprojectwithcustomview.ui.main_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.max.secondworld.globaltestprojectwithcustomview.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}