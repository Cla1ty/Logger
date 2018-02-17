/**************************************************************************************************
 *                                                                                                *
 *                         Created by Dwi Ariyanto (creatures99@gmail.com)                        *
 *                             Copyright © 2017. All rights reserved.                             *
 *                                                                                                *
 *                                                                                                *
 * Created:                                                                                       *
 * Tuesday, October 15, 2017                                                                      *
 *                                                                                                *
 **************************************************************************************************/

package com.dwiariyanto.log

import android.app.Application
import android.content.Context
import android.util.Log
import org.jetbrains.annotations.TestOnly

object Logger {
	
	internal const val TAG = "Logger"
	internal var printer: Printer? = null
	
	fun install(application: Application) {
		printer = Printer(application.packageName)
	}
	
	@TestOnly fun install(context: Context) {
		printer = Printer(context.packageName)
	}
}

fun verbose(
		any: Any,
		tag: String = Logger.TAG
) {
	Logger.printer?.print(
			Log.VERBOSE,
			any,
			tag
	)
}

fun debug(
		any: Any,
		tag: String = Logger.TAG
) {
	Logger.printer?.print(
			Log.DEBUG,
			any,
			tag
	)
}

fun info(
		any: Any,
		tag: String = Logger.TAG
) {
	Logger.printer?.print(
			Log.INFO,
			any,
			tag
	)
}

fun warn(
		any: Any,
		tag: String = Logger.TAG
) {
	Logger.printer?.print(
			Log.WARN,
			any,
			tag
	)
}

fun err(
		any: Any,
		tag: String = Logger.TAG
) {
	Logger.printer?.print(
			Log.ERROR,
			any,
			tag
	)
}

fun assert(
		any: Any,
		tag: String = Logger.TAG
) {
	Logger.printer?.print(
			Log.ASSERT,
			any,
			tag
	)
}
