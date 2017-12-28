package com.shields.streamsms.activities

import android.Manifest
import android.os.Bundle
import com.shields.streamsms.R
import com.shields.streamsms.service.PermissionHelper
import com.shields.streamsms.service.SMSListener
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject

class MainActivityImpl @Inject constructor(val permissionHelper: PermissionHelper,
                                           val processScheduler: Scheduler,
                                           val androidScheduler: Scheduler,
                                           val smsListener: SMSListener) {

    fun onCreate(savedInstanceState: Bundle?, mainActivity: MainActivity) {
        mainActivity.setContentView(R.layout.activity_main)
        permissionHelper.requestPermissionIfNeeded(mainActivity, Manifest.permission.READ_SMS)
    }

    fun listenForSMS() {
        Observable.fromArray(smsListener.messageList)
                .subscribeOn(processScheduler)
                .observeOn(androidScheduler)
                .subscribe(
                        { results -> System.out.println("Yo man dawg")},
                        { error -> System.out.println("Error yo")}
                )
    }

}