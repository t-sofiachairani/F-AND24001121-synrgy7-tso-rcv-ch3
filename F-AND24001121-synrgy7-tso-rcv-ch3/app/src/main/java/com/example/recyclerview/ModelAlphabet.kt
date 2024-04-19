package com.example.recyclerview

import android.os.Parcel
import android.os.Parcelable

data class ModelAlphabet(
    val huruf : String?,
    val dataContent : List<String>?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.createStringArrayList()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(huruf)
        parcel.writeStringList(dataContent)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ModelAlphabet> {
        override fun createFromParcel(parcel: Parcel): ModelAlphabet {
            return ModelAlphabet(parcel)
        }

        override fun newArray(size: Int): Array<ModelAlphabet?> {
            return arrayOfNulls(size)
        }
    }
}
