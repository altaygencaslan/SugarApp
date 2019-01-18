package com.sugarapp.examle.appconfig

import android.app.Application
import com.orm.SugarContext

class AppConfig : Application(){

    override fun onCreate() {
        super.onCreate()
        SugarContext.init(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        SugarContext.terminate()
    }

}