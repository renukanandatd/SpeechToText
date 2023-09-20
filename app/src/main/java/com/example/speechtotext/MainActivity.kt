package com.example.speechtotext

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var imageBtn:Button
    lateinit var text:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageBtn=findViewById(R.id.imageButton)
        text=findViewById(R.id.textContent)

        imageBtn.setOnClickListener {



        }
    }

    fun convertSpeech(){
        val intent= Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
    }
}