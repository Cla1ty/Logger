package com.dwiariyanto.logger.example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dwiariyanto.log.info

class MainActivity : AppCompatActivity() {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		
		val person = Person()
		
		info(person.name)
		/**
		I/Logger: Kristal .onCreate(MainActivity.kt:15) -> MainActivity
		 */
		info(
				person.name,
				person.tag
		)
		/**
		I/Person: Kristal .onCreate(MainActivity.kt:16) -> MainActivity
		 */
		info(person)
		/**
		I/Logger: ===== PERSON =====
		gender : Female
		name : Kristal
		tag : Person
		===== end ===== .onCreate(MainActivity.kt:20) -> MainActivity
		 */
		
		val nameList = listOf(
				"name",
				"Kristal",
				"Kannon"
		)
		info(nameList)
		/**
		I/Logger: ===== NAME =====
		Kristal
		Kannon
		===== end ===== .onCreate(MainActivity.kt:27) -> MainActivity
		 */
		
		val throwable = Throwable("empty")
		info(throwable)
		/**
		I /Logger: empty .onCreate(MainActivity.kt:30) -> MainActivity
		 */
	}
	
	class Person(
			val tag: String = "Person",
			val name: String = "Kristal",
			val gender: String = "Female"
	)
}
