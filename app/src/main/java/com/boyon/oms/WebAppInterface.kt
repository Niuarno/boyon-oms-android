package com.boyon.oms

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.webkit.JavascriptInterface
import android.widget.Toast

class WebAppInterface(private val context: Context) {

    @JavascriptInterface
    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    @JavascriptInterface
    fun triggerHaptic(type: String?) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as? VibratorManager
                val vibrator = vibratorManager?.defaultVibrator
                when (type) {
                    "heavy" -> vibrator?.vibrate(VibrationEffect.createPredefined(VibrationEffect.EFFECT_HEAVY_CLICK))
                    "click" -> vibrator?.vibrate(VibrationEffect.createPredefined(VibrationEffect.EFFECT_CLICK))
                    else -> vibrator?.vibrate(VibrationEffect.createPredefined(VibrationEffect.EFFECT_TICK))
                }
            } else {
                @Suppress("DEPRECATION")
                val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
                vibrator?.vibrate(VibrationEffect.createOneShot(40, VibrationEffect.DEFAULT_AMPLITUDE))
            }
        } catch (_: Exception) {
            // Gracefully ignore vibration errors on unsupported hardware
        }
    }

    @JavascriptInterface
    fun getAppVersion(): String {
        return "1.0.0"
    }

    @JavascriptInterface
    fun isNativeApp(): Boolean {
        return true
    }
}
