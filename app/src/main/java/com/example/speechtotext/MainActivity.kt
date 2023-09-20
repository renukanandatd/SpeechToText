package com.example.speechtotext

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import java.util.ArrayList
import java.util.Locale

class MainActivity : AppCompatActivity() {

    lateinit var imageBtn:Button
    lateinit var text:TextView
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageBtn=findViewById(R.id.imageButton)
        text=findViewById(R.id.textContent)

        activityResultLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback{result->
                val resultCode=result.resultCode
                val data=result.data

                if(resultCode== RESULT_OK && data!=null){
                    val speakResult: ArrayList<String>? =data.
                    getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS) as ArrayList<String>
                    text.text= speakResult!![0]
                }

            })

        imageBtn.setOnClickListener {
            convertSpeech()

        }
    }

    fun convertSpeech(){
        val intent= Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, Locale.getDefault())
        //startActivityForResult(intent,1)
        activityResultLauncher.launch(intent)
    }

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1 && resultCode== RESULT_OK && data!=null){
            val speakResult: ArrayList<String>? =data.
            getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS) as ArrayList<String>
            text.text= speakResult!![0]

        }
    }*/
}