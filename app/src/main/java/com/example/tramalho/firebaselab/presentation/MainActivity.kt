package com.example.tramalho.firebaselab.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tramalho.firebaselab.R
import com.example.tramalho.firebaselab.infraestructure.data.LocalProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*        val retrieveAll = LocalProvider().retrieveAll(this)

        if(retrieveAll.isNotEmpty()) {
            Toast.makeText(this, "Notification persisted: ${retrieveAll.size}", Toast.LENGTH_SHORT).show()
        }*/
    }
}
