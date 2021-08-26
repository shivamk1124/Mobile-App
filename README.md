# Mobile-App
Mobile app for booking sports event tickets

## Prerequisites

- Android Native development environment(Android Studio)
- Java
- JDK 8.+
- Gradel


## Installation

1. Clone the repo:

```
git clone https://github.com/shivamk1124/Mobile-App.git
```

2. Setup Gradel file with required dependencies 

```
implementation 'com.google.code.gson:gson:2.6.2'
implementation 'com.squareup.retrofit2:retrofit:2.0.2'
implementation 'com.squareup.retrofit2:converter-gson:2.0.2'

implementation 'com.android.support:recyclerview-v7:23.3.0'
implementation 'com.sothree.slidinguppanel:library:3.4.0'

implementation 'com.squareup.picasso:picasso:2.71828
```

3. Add Internet permission in the 'Manifest.xml' 

```
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.INTERNET" />
```

4. Run the project(code) on the emulator or real device:

```
Click on the run button in Android Studio ID or Shift+F10
```


