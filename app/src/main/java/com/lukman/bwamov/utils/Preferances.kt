package com.lukman.bwamov.utils

import android.content.Context
import android.content.SharedPreferences

class Preferances (val context: Context) {
    companion object {
        const val MEETING_PREF = "USER_PREF"
    }
    var sharedPref = context.getSharedPreferences(MEETING_PREF, 0)

    fun setValue(key : String, value : String) {
        val editor:SharedPreferences.Editor = sharedPref.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getValues(key: String) : String? {
        return sharedPref.getString(key, "")
    }
}
