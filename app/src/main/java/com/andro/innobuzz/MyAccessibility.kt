package com.andro.innobuzz;

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent

class MyAccessibility : AccessibilityService() {
    val TAG = "MyAccessibility"

    override fun onInterrupt() {}

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        Log.d(TAG, "onAccessibilityEvent: ${event?.eventType}")
        if (event != null) {
            if (event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED)
                if (event.packageName.contains("w4b"))
                    Global.makeToast(baseContext, "Bus Whatsapp Opened")
                else
                    Global.makeToast(baseContext, "Whatsapp Opened")
        }
    }
}
