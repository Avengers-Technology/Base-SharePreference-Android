package com.example.basesharepreference

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.basesharepreference.model.Users
import com.google.gson.Gson
import java.util.*

class MainAct : AppCompatActivity() {
    private val keyObject: String = "keyObject"
    private val keyBoolean: String = "keyBoolean"
    private val keyFloat: String = "keyLong"
    private val keyInt: String = "keyInt"
    private val keyString: String = "keyString"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        baseSharePrefer()




    }

    private fun baseSharePrefer() {
        val preferManager = PreferManager.getInstance(this)

        val user = Users("Smeb",25)

        preferManager?.write(keyString,"Manchester United")
        preferManager?.write(keyInt,1997)
        preferManager?.write(keyFloat,123.3f)
        preferManager?.write(keyBoolean,true)
        preferManager?.write(keyObject,user)

        val dataInt = preferManager!!.readInt(keyInt,0)
        Log.e("Logger",dataInt.toString())

        val dataFloat = preferManager.readFloat(keyFloat,0f)
        Log.e("Logger",dataFloat.toString())

        val dataBoolean = preferManager.readBoolean(keyBoolean,false)
        Log.e("Logger",dataBoolean.toString())

        val dataString = preferManager.readString(keyString,"")
        Log.e("Logger",dataString.toString())

        val gson = Gson()
        val objectUser = gson.fromJson(preferManager.readString(keyObject,""),Users::class.java)
        Log.e("Logger",objectUser.name)
    }
}