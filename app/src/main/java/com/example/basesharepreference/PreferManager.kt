package com.example.basesharepreference

import android.content.Context
import android.content.SharedPreferences
import com.example.basesharepreference.model.Users
import com.google.gson.Gson
import java.util.*
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


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

    // write String + Int + Float + Boolean
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

    // read String + Int + Float + Boolean
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

    // clear all data
    fun clearAllData(){
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.clear().apply()
    }

    // remove data
    fun removeData(key: String?){
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.remove(key).apply()
    }


    // write Object
    fun write(key: String?, users: Users){
        val prefsEditor = sharedPreferences!!.edit()
        val gson = Gson()
        val dataJson = gson.toJson(users)
        prefsEditor.putString(key, dataJson)
        prefsEditor.apply()
    }

    // write List<Object>
    // https://stackoverflow.com/questions/28107647/how-to-save-listobject-to-sharedpreferences (58 vote)
     fun <T> writeListObject(key: String?, list: List<T>?) {
        val gson = Gson()
        val json = gson.toJson(list)
        write(key, json)
    }

    // read List<Object>
     fun readListObject(key: String?): List<Users> {
        var listUser: List<Users> = emptyList()
        val serializedObject = sharedPreferences!!.getString(key, null)
        if (serializedObject != null) {
            val gson = Gson()
            val type: Type = object : TypeToken<List<Users>>() {}.type
            listUser = gson.fromJson(serializedObject, type)
        }
        return listUser
    }
}