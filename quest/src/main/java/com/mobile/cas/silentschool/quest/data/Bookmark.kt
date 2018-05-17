package com.mobile.cas.silentschool.quest.data

import android.os.Parcel
import android.os.Parcelable

data class Bookmark(val chapter: Int = 0, val page: Int = 0) : Parcelable {

    fun isEmpty(): Boolean = (chapter == 0) and (page == 0)

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(chapter)
        parcel.writeInt(page)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Bookmark> {
        override fun createFromParcel(parcel: Parcel): Bookmark {
            return Bookmark(parcel)
        }

        override fun newArray(size: Int): Array<Bookmark?> {
            return arrayOfNulls(size)
        }
    }
}