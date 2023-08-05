package com.example.savelistobjectsharedpreferences

import android.app.Application
import com.example.savelistobjectsharedpreferences.data_local.DataLocalManager

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DataLocalManager.init(applicationContext)
    }
}