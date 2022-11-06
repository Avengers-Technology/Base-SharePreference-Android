package com.example.basesharepreference

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.basesharepreference.model.Users

class MainAct : AppCompatActivity() {
    private val keyListObject: String = "keyListObject"
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

        // Save + Read type Int, Float, Boolean, String
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


        // Save + Read type Object
        val user = Users("Smeb",26)
        preferManager.writeObject(keyObject,user)

        val objectUser = preferManager.readObject(keyObject, Users::class.java ) as Users
        Log.e("Logger",objectUser.name+"->"+objectUser.age)

        // Save + Read type List<Object>
        val listUser = mutableListOf<Users>()
        listUser.add(Users("HiepPD",17))
        listUser.add(Users("LienNP",29))


        preferManager.writeListObject(keyListObject,listUser)

        val resultListUser = preferManager.readListObject(keyListObject, Users::class)
        Log.e("Logger", "resultListUser : $resultListUser")
        Log.e("Logger", resultListUser[0].name+"/"+resultListUser[1].name)
    }
}