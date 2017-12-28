package com.shields.streamsms.service

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.Context
import android.telephony.SmsMessage
import android.widget.Toast


class SMSListener : BroadcastReceiver() {

    var messageList : List<String> = ArrayList()

    override fun onReceive(context: Context, intent: Intent) {
        val bundle = intent.extras

        try {

            if (bundle != null) {

                val pdusObj = bundle.get("pdus") as Array<Any>

                for (i in pdusObj.indices) {

                    val currentMessage = SmsMessage.createFromPdu(pdusObj[i] as ByteArray)
                    val phoneNumber = currentMessage.displayOriginatingAddress

                    val message = currentMessage.displayMessageBody
                    messageList += message

//                    Log.i("SmsReceiver", "senderNum: $phoneNumber; message: $message")


                    // Show alert
                    val duration = Toast.LENGTH_LONG
                    val toast = Toast.makeText(context, "senderNum: $phoneNumber, message: $message", duration)
                    toast.show()

                } // end for loop
            } // bundle is null

        } catch (e: Exception) {
//            Log.e("SmsReceiver", "Exception smsReceiver" + e)

        }

    }
}