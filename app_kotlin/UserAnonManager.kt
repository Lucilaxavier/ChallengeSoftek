package com.softtek.challenge.data

import android.content.Context
import android.content.SharedPreferences
import java.util.UUID

object UserAnonManager {
    private const val PREF_NAME = "anon_user_prefs"
    private const val KEY_UUID = "anon_uuid"

    fun getAnonId(context: Context): String {
        val prefs: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        var uuid = prefs.getString(KEY_UUID, null)
        if (uuid == null) {
            uuid = UUID.randomUUID().toString()
            prefs.edit().putString(KEY_UUID, uuid).apply()
        }
        return uuid
    }
}
