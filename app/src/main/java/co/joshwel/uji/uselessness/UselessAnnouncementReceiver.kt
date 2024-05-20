package co.joshwel.uji.uselessness

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import co.joshwel.uji.NotificationMailman
import co.joshwel.uji.UjiCommons


private const val TAG = "UselessAnnReceiver"

val kaomojis = arrayOf(
    "ヾ(≧▽≦*)o",
    "φ(*￣0￣)",
    "q(≧▽≦q)",
    "ψ(｀∇´)ψ",
    "（￣︶￣）↗",
    "*^____^*",
    "(～￣▽￣)～",
    "( •̀ ω •́ )",
    "φ(゜▽゜*)♪",
    "o(*^＠^*)o",
    "O(∩_∩)O",
    "(✿◡‿◡)",
    "(*^▽^*)",
    "（*＾-＾*）",
    "(*^_^*)",
    "(❁´◡`❁)",
    "(≧∇≦)ﾉ",
    "(￣y▽￣)╭",
    "\\^o^/",
    "(*^▽^*)┛",
    "♪(^∇^*)",
    "(≧∀≦)",
    "(oﾟvﾟ)o",
    "(o≧▽≦)o",
    "(/≧▽≦)/",
    "(*︾▽︾)",
    "(≧ ▽ ≦)",
    "o(≧▽≦)o",
    "(((o(*ﾟ▽ﾟ*)o)))",
    "♪(´▽｀)",
    "( *^-^)",
    "(^v^)",
    "(o゜▽゜)o☆"
)

val messages = arrayOf(
    "wake up! 18 minutes have passed!",
    "18 minutes have passed!",
    "ah! 18 minutes have passed!!!!!!!!",
    "hey! 18 minutes have passed! did you know?",
    "hey, guess what? 18 minutes have passed!,",
    "18 minutes have passed...",
)


class UselessAnnouncementReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // null checks
        if (intent == null) {
            Log.e(TAG, "received null intent")
            return
        }
        if (context == null) {
            Log.e(TAG, "received null context")
            return
        }

        // security check (is this us?)
        if (intent.action != UjiCommons.NOTIFICATION_ACTION) {
            Log.e(TAG, "received something not from us")
            Log.e(TAG, "... intent.action=${intent.action}")
            Log.e(TAG, "... context=${context}")
            Log.e(TAG, "... intent=${intent}")
            return
        }

        Log.d(TAG, "received uji's useless announcement")

        val mailman = NotificationMailman(context)
        mailman.sendNotification(mailman.buildNotification("${messages.random()} ${kaomojis.random()}"))
    }
}
