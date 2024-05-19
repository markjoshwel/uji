package co.joshwel.uji.uselessness

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import co.joshwel.uji.UjiCommons
import java.time.ZoneId


private const val TAG = "UselessScheduler"


interface UselessSchedulerInterface {
    fun dispatch(announcement: UselessAnnouncement)
    fun destroy(announcement: UselessAnnouncement)
}


class UselessScheduler(private val context: Context) : UselessSchedulerInterface {
    private val alarmManager = context.getSystemService(AlarmManager::class.java)

    override fun dispatch(announcement: UselessAnnouncement) {
        val intent = Intent(context, UselessAnnouncementReceiver::class.java).apply {
            setAction(UjiCommons.NOTIFICATION_ACTION)
        }

        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            announcement.time.atZone(ZoneId.systemDefault()).toEpochSecond() * 1000,
            UjiCommons.NOTIFICATION_INTERVAL,
            PendingIntent.getBroadcast(
                context,
                UjiCommons.NOTIFICATION_REQUEST_CODE,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
            )
        )

        Log.d(TAG, "successfully dispatched")
    }

    override fun destroy(announcement: UselessAnnouncement) {
        alarmManager.cancel(
            PendingIntent.getBroadcast(
                context,
                UjiCommons.NOTIFICATION_REQUEST_CODE,
                Intent(context, UselessAnnouncementReceiver::class.java),
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
            )
        )
    }
}
