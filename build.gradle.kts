buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath(Libraries.GradlePlugin.android)
        classpath(Libraries.GradlePlugin.kotlin)
        classpath(Libraries.GradlePlugin.daggerHilt)
        classpath(Libraries.GradlePlugin.safeArgs)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.21")
    }
}

tasks.register("clean") {
    delete(rootProject.buildDir)
}