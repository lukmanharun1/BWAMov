package com.lukman.bwamov.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film (
    var desc : String ? = "",
    var director : String ? = "",
    var genre : String ? = "",
    var poster : String ? = "",
    var rating : String ? = "",
    var judul : String ? = ""

) : Parcelable