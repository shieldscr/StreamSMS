package com.shields.streamsms.application

import android.app.Application
import com.shields.streamsms.injection.ApplicationComponent
import com.shields.streamsms.injection.ApplicationModule
import com.shields.streamsms.injection.DaggerApplicationComponent

class StreamSMSApplication
constructor(private val applicationComponentFactory: ApplicationComponentFactory = ApplicationComponentFactory()) : Application() {

    override fun onCreate() {
        super.onCreate()
        configure()
    }

    private fun configure() {
        applicationComponent = applicationComponentFactory.build()
        applicationComponent.inject(this)
    }

    companion object {
        //platformStatic allow access it from java code
        lateinit var applicationComponent: ApplicationComponent
    }
}

class ApplicationComponentFactory {
    fun build() : ApplicationComponent {
        return DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule())
                .build()
    }
}