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

import android.util.Log

internal class Printer(
		private val packageName: String
) {
	
	fun print(
			level: Int,
			any: Any,
			tag: String
	) {
		
		val data = Data()
		
		getLinkAndFileName(data)
		getMessage(
				any,
				data
		)
		
		Log.println(
				level,
				tag,
				data.message
		)
	}
	
	private fun getMessage(
			any: Any,
			data: Data
	) {
		when (any) {
			is String    -> {
				data.message = any
			}
			is List<*>   -> {
				for (i in 0 until any.size) {
					if (i == 0) {
						data.message = "===== ${any[i].toString().toUpperCase()} ====="
					} else {
						data.message += "\n${any[i]}"
					}
				}
				data.message += "\n===== end ====="
			}
			is Throwable -> {
				data.message = any.message!!
				data.throwable = any
			}
			else         -> {
				data.message = "===== ${any.javaClass.simpleName.toUpperCase()} ====="
				for (field in any.javaClass.declaredFields) {
					if (field.name == "\$change" || field.name == "serialVersionUID") continue
					
					field.isAccessible = true
					data.message += "\n" + field.name + " : " + field.get(any)
				}
				data.message += "\n===== end ====="
			}
		}
		
		data.message += " ${data.link} -> ${data.fileName}"
	}
	
	private fun getLinkAndFileName(data: Data) {
		val stackTrace = Throwable().stackTrace
		
		var source = stackTrace[0]
		var parent = stackTrace[0]
		
		var isSourceSet = false
		var isParentSet = false
		
		for (trace in stackTrace) {
			if (trace.className.contains(packageName)) {
				if (!isSourceSet) {
					isSourceSet = true
					source = trace
				}
				
				isParentSet = true
				parent = trace
			} else if (isParentSet) {
				break
			}
		}
		
		data.link = ".${source.methodName}(${source.fileName}:${source.lineNumber})"
		data.fileName = parent.fileName.split('.')[0]
	}
	
	class Data {
		var message = ""
		var throwable: Throwable? = null
		
		internal lateinit var link: String
		internal lateinit var fileName: String
	}
}
