package com.bragamonte.developer.sas

import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.telephony.SmsManager
import android.widget.Toast
import com.bragamonte.developer.sas.R.id.clickSendSms
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    private val requestSendSms: Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        clickSendSms.setOnClickListener({
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.SEND_SMS), requestSendSms)
            } else {
                sendSMS()
            }
        })
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == requestSendSms) sendSMS()
    }

    private fun sendSMS() {
        val number: String = "5551993941175"
        val message: String = "Kotlin SMS Test"



        try {
            SmsManager.getDefault().sendTextMessage(number, null, message, null, null)
            Toast.makeText(this, "SMS Sent", Toast.LENGTH_SHORT).show()

        } catch (e: Exception) {
            Toast.makeText(this, "Ooops, an error ocurred", Toast.LENGTH_SHORT).show()
        }


    }
}
