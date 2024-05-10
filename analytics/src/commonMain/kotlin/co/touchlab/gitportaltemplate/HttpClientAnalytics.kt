package co.touchlab.gitportaltemplate

class HttpClientAnalytics internal constructor() {
    
    fun logMessage(message: String) {
        sendEvent("httpClientMessage", "message" to message)
    }
}