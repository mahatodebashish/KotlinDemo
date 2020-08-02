# KotlinDemo

Gradle
Add dependencies (you can also add other modules that you need):

dependencies {
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8'
}


And make sure that you use the latest Kotlin version:

buildscript {
    ext.kotlin_version = '1.3.71'
}


Make sure that you have either jcenter() or mavenCentral() in the list of repositories:

repository {
    jcenter()
}
