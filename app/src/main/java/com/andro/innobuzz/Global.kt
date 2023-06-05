package com.andro.innobuzz

import android.content.Context
import android.widget.Toast

class Global {
    companion object {
        fun makeToast(context: Context, msg: String) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }

}