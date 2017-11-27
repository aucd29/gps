# gps
[![Build Status](https://travis-ci.org/aucd29/gps.svg?branch=master)](https://travis-ci.org/aucd29/gps)

Add it to your build.gradle with:
```gradle
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

Step 2. Add the dependency

```gradle
dependencies {
    compile 'com.github.aucd29:gps:1.0.0'
}
```
```gradle
// kotlin 
dependencies {
    implementation 'com.github.aucd29:gps:2.0.0'

    implementation('com.github.tony19:logback-android-classic:1.1.1-3') {
        exclude group: 'com.google.android', module: 'android'
    }
    implementation ('com.github.tony19:logback-android-core:1.1.1-3')  {
        exclude group: 'com.google.android', module: 'android'
    }
    implementation 'org.slf4j:slf4j-api:1.7.5'
    implementation 'com.github.aucd29:retro-jackson:1.0.0'
    implementation 'com.github.aucd29:permission:2.0.0'
    implementation 'com.squareup.retrofit2:retrofit:2.3.0'
    implementation 'com.squareup.retrofit2:converter-jackson:2.3.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:3.4.2'
    implementation "com.fasterxml.jackson.module:jackson-module-kotlin:2.9.0"
}
```
