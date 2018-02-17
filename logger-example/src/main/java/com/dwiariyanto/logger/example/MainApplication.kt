package com.dwiariyanto.logger.example

import android.app.Application
import com.dwiariyanto.log.Logger

class MainApplication : Application() {
	override fun onCreate() {
		super.onCreate()
		
		if (BuildConfig.DEBUG) {
			Logger.install(this)
		}
	}
}
