package com.example.islami.adapters.quran

data class Quran(
    val ayatCounts: String,
    val suraNumber: String,
    val suraNameAr: String,
    val suraNameEn: String? = null,
    val sura: String? = null,
)
