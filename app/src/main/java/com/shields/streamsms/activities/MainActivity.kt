package com.shields.streamsms.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.shields.streamsms.application.StreamSMSApplication
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainActivityImpl: MainActivityImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StreamSMSApplication.applicationComponent.inject(this)

        mainActivityImpl.onCreate(savedInstanceState, this)
    }
}
