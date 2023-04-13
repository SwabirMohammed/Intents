package com.example.swabir_intents

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {
   private lateinit var smsbutton:Button
    private lateinit var emailbutton:Button
    private lateinit var camerabutton:Button
    private lateinit var sharebutton:Button
    private lateinit var callbutton:Button
    private lateinit var mpesabutton:Button
    private lateinit var websitebutton:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        smsbutton = findViewById(R.id.btnsms)
        emailbutton = findViewById(R.id.btnemail)
        camerabutton = findViewById(R.id.btncamera)
        sharebutton = findViewById(R.id.btnshare)
        callbutton = findViewById(R.id.btncall)
        mpesabutton = findViewById(R.id.btnmpesa)
        websitebutton = findViewById(R.id.btnwebsite)

        websitebutton.setOnClickListener {
            val gotowebsite = Intent(this, WebsiteActivity::class.java)
            startActivity(gotowebsite)
        }

        callbutton.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0769302565"))
            startActivity(intent)
        }


        mpesabutton.setOnClickListener {
            val simToolKitIntent = application.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitIntent?.let { startActivity(it) }
        }


        camerabutton.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)

        }


        emailbutton.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto:swabir49@gmail.com", "swabir49@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "JOB APPLICATION")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear Sir, I'm applying for the position of assistant Managing Director")
            startActivity(Intent.createChooser(emailIntent, "Send Email..."))
        }

        smsbutton.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:0769302565")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "Wagwan bruv")
            startActivity(intent)
        }

    }
}