# Logger

Simple logs with links to code

## Library

```
logger/libs/com.dwiariyanto.logger-${version}.aar
```

## Dependency

```
copy file arr to ${your_module}/libs/

open build.gradle and add this line
  implementation fileTree(include: ['*.aar'], dir: 'libs')
```

## Function

Install
```kotlin
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Logger.install(this)
        }
    }
}
```

Code
```kotlin
class Person(
    val tag: String = "Person",
    val name: String = "Kristal",
    val gender: String = "Female"
)
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
```
