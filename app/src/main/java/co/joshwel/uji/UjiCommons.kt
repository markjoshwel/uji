package co.joshwel.uji

class UjiCommons {
    companion object {
        const val APP_NAME: String = "Uji"
        const val APP_RELEASE_YEAR: Int = 2024

        const val CHANNEL_ID: String = APP_NAME
        const val CHANNEL_NAME: String = "${APP_NAME}'s Announcements"
        const val CHANNEL_DESCRIPTION: String = "${APP_NAME}'s USELESS announcements"

        const val NOTIFICATION_TITLE: String = APP_NAME
        const val NOTIFICATION_ID: Int = 117_106_105

        //const val NOTIFICATION_INTERVAL: Long = 1080000
        const val NOTIFICATION_INTERVAL: Long = 60000
        const val NOTIFICATION_REQUEST_CODE: Int = 21_10_09
        const val NOTIFICATION_ACTION: String = "co.joshwel.uji.ANNOUNCEMENT"
    }
}
