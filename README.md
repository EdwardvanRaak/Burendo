# Burendo
A very simple Blendle client that retrieves popular items and displays it inside a minimalistic material design UI.

Video and apk are in the root directory - Edward van Raak

###Build

Android Studio:  Gradle Pane gradlew assembleRelease

Linux:  ./gradlew assembleRelease

Windows: gradlew assembleRelease

Apk generated under: app\build\outputs\apk

#####Sidenote about the shared view animation:
You might notice that going back to the list from the item content screen is a bit jerky and reloads the entire popular item list. This obviously is not inteded behaviour but a proper solution probably requires item caching on memory or disk. Doing an activity to activity transition would also work, but right now it's fragment to fragment which requires a replace fragment transaction.
