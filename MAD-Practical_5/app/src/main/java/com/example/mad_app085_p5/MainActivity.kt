package com.example.mad_app085_p5

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var edt_weburl: EditText = findViewById(R.id.edt_weburl)
        var edt_phoneno: EditText = findViewById(R.id.edt_phoneno)
        var btn_browse: Button = findViewById(R.id.btn_browse)
        var btn_call: Button = findViewById(R.id.btn_call)
        var btn_calllog: Button = findViewById(R.id.btn_calllog)
        var btn_gallery: Button = findViewById(R.id.btn_gallery)
        var btn_camera: Button = findViewById(R.id.btn_camera)
        var btn_alarm: Button = findViewById(R.id.btn_alarm)

        btn_browse.setOnClickListener{
            if(edt_weburl.text.toString().isNotEmpty()){
                Intent(Intent.ACTION_VIEW, Uri.parse("https://${edt_weburl.text.toString()}")).also { startActivity(it) }
            }
            else if(edt_weburl.text.toString()  == ""){
                Toast.makeText(this,"Enter url to browse!",Toast.LENGTH_SHORT).show()
            }
        }

        btn_call.setOnClickListener {
            if(edt_phoneno.text.toString().isNotEmpty()){
                Intent(Intent.ACTION_DIAL, Uri.parse("tel:${edt_phoneno.text.toString()}")).also { startActivity(it) }
//                Intent(Intent.ACTION_CALL, Uri.parse("tel:${edt_phoneno.text.toString()}")).also { startActivity(it) }
            }
            else if(edt_phoneno.text.toString()  == ""){
                Toast.makeText(this,"Enter mobile number to make call!",Toast.LENGTH_SHORT).show()
            }
        }

        btn_calllog.setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
        }

        btn_gallery.setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType("image/*").also { startActivity(it) }
        }

        btn_camera.setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
        }

        btn_alarm.setOnClickListener {
            Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
//            Intent(AlarmClock.ACTION_SET_ALARM).also { startActivity(it) }
        }
    }
}