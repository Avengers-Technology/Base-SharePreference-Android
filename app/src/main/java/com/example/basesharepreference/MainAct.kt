package com.example.basesharepreference

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainAct : AppCompatActivity() {
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

        preferManager?.write(keyString,"Manchester United")
        preferManager?.write(keyInt,1997)
        preferManager?.write(keyFloat,123.3f)
        preferManager?.write(keyBoolean,true)


        val dataInt = preferManager!!.readInt(keyInt,0)
        Log.e("Logger",dataInt.toString())

        val dataFloat = preferManager.readFloat(keyFloat,0f)
        Log.e("Logger",dataFloat.toString())

        val dataBoolean = preferManager.readBoolean(keyBoolean,false)
        Log.e("Logger",dataBoolean.toString())

        val dataString = preferManager.readString(keyString,"")
        Log.e("Logger",dataString.toString())
    }
}