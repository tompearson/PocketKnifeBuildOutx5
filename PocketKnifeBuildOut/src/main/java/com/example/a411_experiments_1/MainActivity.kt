package com.example.a411_experiments_1

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.library_isitrooted.isItRooted

import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.Flags
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import com.microsoft.appcenter.distribute.Distribute
import com.microsoft.appcenter.utils.async.AppCenterConsumer


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var toast: Toast
        lateinit var textMessage: TextView
        lateinit var button: Button
        lateinit var crash_button: Button

        val builder = StringBuilder()
        val properties: Map<String, String> = HashMap()

        // Setup buttons
        button = findViewById(R.id.button_Map_id)
        button.setText(R.string.title_map_button)

        crash_button = findViewById(R.id.button_crash_id)
        crash_button.setText(R.string.button_crash_text)

        textMessage = findViewById(R.id.message)
        textMessage.setTextColor(Color.BLACK)

        AppCenter.start(
            application, "e93f7bb5-d8b0-467f-8ea0-d20db09a2cb8",
            Analytics::class.java, Crashes::class.java, Distribute::class.java
        )
        val future = Crashes.hasCrashedInLastSession()
        future.thenAccept(AppCenterConsumer {
            if (it) {
                Analytics.trackEvent(getString(R.string.crash_detected), properties, Flags.CRITICAL)
                Toast.makeText(this, getText(R.string.crash_oops), Toast.LENGTH_LONG).show()
            }
        })

//        methodWithPermissions(this)

        textMessage.setText(isItRooted(this, builder))


    }
}