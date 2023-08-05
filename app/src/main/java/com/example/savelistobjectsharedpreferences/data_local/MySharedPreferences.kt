package com.example.savelistobjectsharedpreferences.data_local

import android.content.Context
import android.content.SharedPreferences

private const val MY_SHARED_PREFERENCES = "MY_SHARED_PREFERENCES"

class MySharedPreferences (private val context: Context) {

    fun putStringValue(key: String, value: String) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
            MY_SHARED_PREFERENCES, Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getStringValue(key: String): String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
            MY_SHARED_PREFERENCES, Context.MODE_PRIVATE
        )
        return sharedPreferences.getString(key, "")
    }
}