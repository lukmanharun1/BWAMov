package com.lukman.bwamov.utils

import android.content.Context
import android.content.SharedPreferences

class Preferances (val context: Context) {
    companion object {
        const val USER_PREFF = "USER_PREFF"
    }
    var sharedPreferances = context.getSharedPreferences(USER_PREFF, 0)

    fun setValue(key : String, value : String) {
        val editor:SharedPreferences.Editor = sharedPreferances.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getValues(key: String) : String? {
        return sharedPreferances.getString(key, "")
    }
}
