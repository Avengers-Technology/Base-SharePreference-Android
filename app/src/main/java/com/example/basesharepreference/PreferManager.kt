package com.example.basesharepreference

import android.content.Context
import android.content.SharedPreferences


class PreferManager private constructor(context: Context) {
    private val sharedPreferences: SharedPreferences? = context.getSharedPreferences("YourCustomNamedPreference", Context.MODE_PRIVATE)

    companion object {
        private var preferManager: PreferManager? = null
        fun getInstance(context: Context): PreferManager? {
            if (preferManager == null) {
                preferManager = PreferManager(context)
            }
            return preferManager
        }
    }

    fun write(key: String?, value: String?) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putString(key, value)
        prefsEditor.apply()
    }

    fun write(key: String?, value: Boolean) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putBoolean(key, value)
        prefsEditor.apply()
    }

    fun write(key: String?, value: Int) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putInt(key, value)
        prefsEditor.apply()
    }

    fun write(key: String?, value: Float) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putFloat(key, value)
        prefsEditor.apply()
    }

    fun readString(key: String?, defValue: String?): String? {
        return if (sharedPreferences != null) {
            sharedPreferences.getString(key, defValue)
        } else defValue
    }

    fun readInt(key: String?, defValue: Int): Int {
        return sharedPreferences?.getInt(key, defValue) ?: defValue
    }

    fun readFloat(key: String?, defValue: Float): Float {
        return sharedPreferences?.getFloat(key, defValue) ?: defValue
    }

    fun readBoolean(key: String?, defValue: Boolean ): Boolean {
        return sharedPreferences?.getBoolean(key, defValue) ?: defValue
    }


}