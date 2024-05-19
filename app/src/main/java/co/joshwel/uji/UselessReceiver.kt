package co.joshwel.uji

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.RingtoneManager
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

const val CHANNEL_ID = "uji"
val channel = NotificationChannel(
    CHANNEL_ID,
    "Uji's Announcements",
    NotificationManager.IMPORTANCE_HIGH
).apply {
    description = "Uji's USELESS announcements"
}


class UselessReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        println("UselessReceiver.onReceive: received something")

        val message = intent?.getStringExtra("EXTRA_MESSAGE") ?: return
        if (context == null) {
            println("UselessReceiver.onReceive: received real intent but null context (potentially unreachable?)")
            return
        }

        println("UselessReceiver.onReceive: received uji's useless announcement from system: $message")

        val notificationManager = NotificationManagerCompat.from(context)
        val notificationIntent = Intent(context, UselessReceiver::class.java)
        val notificationPendingIntent =
            PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE)
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Uji")
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))

        builder.setContentIntent(notificationPendingIntent)
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: request for this when enabling uji
            notificationManager.notify(1, builder.build())
            println("UselessReceiver.onReceive: notified!")
        } else {
            println("UselessReceiver.onReceive: did not notify...")
        }
    }
}