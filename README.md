# Burendo
Android Developer Assignment for Blendle

A very simple Blendle client that retrieves popular items and displays it inside a minimalistic material design UI.

Video and apk are in the root directory - Edward van Raak

###TODO:

* ~~Create basic communication with Blendle API using Retrofit~~
* ~~Retrieve popular data as POJO objects~~
* ~~Create a fragment, recyclerview and layouts for the UI~~
* ~~Use retrieved API data to inject data into UI~~
* ~~Create a new fragment that shows item content with a shared elements transtition~~
* Error handling, caching, painting layouts, heck I could spend another 16 hours on this if I wanted ;)

###Build

Android Studio:  Gradle Pane gradlew assembleRelease

Linux:  ./gradlew assembleRelease

Windows: gradlew assembleRelease

Apk generated under: app\build\outputs\apk

#####Sidenote about the shared view animation:
You might notice that going back to the list from the item content screen is a bit jerky and reloads the entire popular item list. This obviously is not inteded behaviour but a proper solution probably requires item caching on memory or disk. Doing an activity to activity transition would also work, but right now it's fragment to fragment which requires a replace fragment transaction.
