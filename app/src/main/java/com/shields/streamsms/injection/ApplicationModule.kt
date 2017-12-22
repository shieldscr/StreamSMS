package com.shields.streamsms.injection

import com.shields.streamsms.activities.MainActivityImpl
import dagger.Module
import dagger.Provides

@Module
open class ApplicationModule {

    @Provides
    fun makeMainActivityImpl(): MainActivityImpl {
        return MainActivityImpl()
    }
}