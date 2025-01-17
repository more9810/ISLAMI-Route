package com.example.islami.models

import android.content.Context

object DataManger {


    fun Context.readFromAsset(fileName : String) : String{
        return assets.open(fileName).bufferedReader().use {
            it.readText()}
    }
}