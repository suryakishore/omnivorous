package com.example.omnicuris

import android.os.Parcel
import android.os.Parcelable

class Question(): Parcelable {

    var option1:String?=null
    var option2:String?=null
    var option3:String?=null
    var option4:String?=null
    var question:String?=null
     var isSelectedCorrect:Boolean?=null
    var correctAnswer:String?=null
    var yourAnswer:String?=null

    constructor(parcel: Parcel) : this() {
        option1 = parcel.readString()
        option2 = parcel.readString()
        option3 = parcel.readString()
        option4 = parcel.readString()
        question = parcel.readString()
        isSelectedCorrect = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        correctAnswer = parcel.readString()
        yourAnswer = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(option1)
        parcel.writeString(option2)
        parcel.writeString(option3)
        parcel.writeString(option4)
        parcel.writeString(question)
        parcel.writeValue(isSelectedCorrect)
        parcel.writeString(correctAnswer)
        parcel.writeString(yourAnswer)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Question> {
        override fun createFromParcel(parcel: Parcel): Question {
            return Question(parcel)
        }

        override fun newArray(size: Int): Array<Question?> {
            return arrayOfNulls(size)
        }
    }


}