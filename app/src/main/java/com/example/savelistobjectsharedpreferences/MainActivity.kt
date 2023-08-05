package com.example.savelistobjectsharedpreferences

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.savelistobjectsharedpreferences.data_local.DataLocalManager

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user1 = User("1", "1")
        val user2 = User("2", "2")
        val list = ArrayList<User>()
        list.add(user1)
        list.add(user2)

        DataLocalManager.setListUsers(list)

        val btn = findViewById<Button>(R.id.btn_view)
        val textView = findViewById<TextView>(R.id.txt_view)

        btn.setOnClickListener {
            val listUser : List<User> = DataLocalManager.getListUsers()
            textView.text = listUser[0].toString() + "\n" + listUser[1].toString()
        }
    }
}
