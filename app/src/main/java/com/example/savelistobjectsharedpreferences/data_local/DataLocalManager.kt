package com.example.savelistobjectsharedpreferences.data_local

import android.content.Context
import com.example.savelistobjectsharedpreferences.User
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

private const val PREF_LIST_USER = "PREF_LIST_USER"

class DataLocalManager {

    private lateinit var mySharedPreferences: MySharedPreferences

    companion object {
        private val instance = DataLocalManager()

        fun init(context: Context) {
            instance.mySharedPreferences = MySharedPreferences(context)
        }

        fun setListUsers(list: List<User>) {
            val jsonArray = Gson().toJsonTree(list).asJsonArray
            val strJsonArray = jsonArray.toString()
            instance.mySharedPreferences.putStringValue(PREF_LIST_USER, strJsonArray)
        }

        fun getListUsers() : List<User> {
            val list = ArrayList<User>()
            val strJsonArray = instance.mySharedPreferences.getStringValue(PREF_LIST_USER)

            if (!strJsonArray.isNullOrEmpty()) {
                val jsonArray = JSONArray(strJsonArray)

                var jsonObject : JSONObject
                var user : User
                for (i in 0 until jsonArray.length()) {
                    jsonObject = jsonArray.getJSONObject(i)
                    user = Gson().fromJson(jsonObject.toString(), User::class.java)
                    list.add(user)
                }
            }
            return list
        }

    }
}