package co.joshwel.uji

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import java.time.ZoneId

class UselessScheduler(
    private val context: Context
) : UselessSchedulerInterface {

    private val alarmManager = context.getSystemService(AlarmManager::class.java)

    override fun dispatch(announcement: UselessAnnouncement) {
        // ask for perms before anything
        val intent = Intent(context, UselessReceiver::class.java).apply {
            putExtra("EXTRA_MESSAGE", announcement.message)
        }

        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            announcement.time.atZone(ZoneId.systemDefault()).toEpochSecond() * 1000,
            1080000,
            PendingIntent.getBroadcast(
                context,
                announcement.hashCode(),
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
            )
        )

        println("UselessScheduler.dispatch: successfully dispatched")
    }

    override fun destroy(announcement: UselessAnnouncement) {
        alarmManager.cancel(
            PendingIntent.getBroadcast(
                context,
                announcement.hashCode(),
                Intent(context, UselessReceiver::class.java),
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
            )
        )
    }
}
