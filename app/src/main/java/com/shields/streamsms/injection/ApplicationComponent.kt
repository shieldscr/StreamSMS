package com.shields.streamsms.injection

import com.shields.streamsms.activities.MainActivity
import com.shields.streamsms.activities.MainActivityImpl
import com.shields.streamsms.application.StreamSMSApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(streamSMSApplication: StreamSMSApplication)
    fun inject(mainActivity: MainActivity)
    fun inject(mainActivityImpl: MainActivityImpl)
}