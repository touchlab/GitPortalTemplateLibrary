package co.touchlab.gitportaltemplate

fun startSDK(analytics: Analytics): SDKHandle {
    val analyticsHandle = initAnalytics(analytics)
    return SDKHandle(
        breedRepository = breedStartup(analyticsHandle),
        appAnalytics = analyticsHandle.appAnalytics,
        breedAnalytics = analyticsHandle.breedAnalytics
    )
}

/**
 * Hello again
 */
fun sayHello() = "Hello from Kotlin!"