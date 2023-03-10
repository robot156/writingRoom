import org.gradle.api.JavaVersion

object Config {
    const val applicationId = "com.minjin.writingroom"

    const val minSdk = 24
    const val targetSdk = 33
    const val compileSdk = 33
    val javaCompileTarget = JavaVersion.VERSION_11

    private const val versionMajor = 1
    private const val versionMinor = 0
    private const val versionPatch = 0

    const val versionName = "$versionMajor.$versionMinor.$versionPatch"
    const val versionCode = versionMajor.times(1000000) + versionMinor.times(1000) + versionPatch
}