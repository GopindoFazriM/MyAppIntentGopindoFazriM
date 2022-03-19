package com.example.myintentappgopindo
import android.os.Parcel
import android.os.Parcelable

data class Person(
    val NAMA    : String?,
    val UMUR    : Int?,
    val EMAIL   : String?,
    val KOTA    : String?
) : Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as?
                Int,
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(NAMA)
        parcel.writeValue(UMUR)
        parcel.writeString(EMAIL)
        parcel.writeString(KOTA)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }
}