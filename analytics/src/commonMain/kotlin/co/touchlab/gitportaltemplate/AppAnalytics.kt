package co.touchlab.gitportaltemplate

class AppAnalytics internal constructor() {
    
    fun appStarted() {
        sendEvent("appStarted")
    }
}