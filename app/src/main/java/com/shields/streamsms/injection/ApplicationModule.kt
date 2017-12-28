package com.shields.streamsms.injection

import com.shields.streamsms.activities.MainActivityImpl
import com.shields.streamsms.service.PermissionHelper
import com.shields.streamsms.service.SMSListener
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
open class ApplicationModule {

    @Provides
    @Named("process")
    @Singleton
    fun makeProcessScheduler(): Scheduler {
        return Schedulers.io()
    }

    @Provides
    @Named("main")
    @Singleton
    fun makeAndroidScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    @Provides
    @Singleton
    fun makeSMSListener(): SMSListener {
        return SMSListener()
    }

    @Provides
    @Singleton
    fun makePermissionHelper(): PermissionHelper {
        return PermissionHelper()
    }

    @Provides
    fun makeMainActivityImpl(@Named("process") processScheduler: Scheduler,
                             @Named("main") androidScheduler: Scheduler,
                             smsListener: SMSListener,
                             permissionHelper: PermissionHelper): MainActivityImpl {
        return MainActivityImpl(permissionHelper, processScheduler, androidScheduler, smsListener)
    }

}