package co.joshwel.uji.uselessness

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import co.joshwel.uji.NotificationMailman

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


class UselessReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (context == null) {
            println("UselessReceiver.onReceive: received real intent but null context (potentially unreachable?)")
            return
        }

        println("UselessReceiver.onReceive: received uji's useless announcement")

        val mailman = NotificationMailman(context)
        mailman.sendNotification(mailman.buildNotification("${messages.random()} ${kaomojis.random()}"))
    }
}