package com.learn.distonary.model

import com.google.gson.annotations.SerializedName
import com.learn.distonary.model.data.Meanings

class DataModel (
    @field:SerializedName("text") val text: String?,
    @field:SerializedName("meanings") val meanings: List<Meanings>
    )


