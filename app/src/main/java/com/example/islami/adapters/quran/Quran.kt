package com.example.islami.adapters.quran

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Quran(
    val ayatCounts: String,
    val suraNumber: String,
    val suraNameAr: String,
    val suraNameEn: String? = null,
    val sura: String? = null,
): Parcelable
