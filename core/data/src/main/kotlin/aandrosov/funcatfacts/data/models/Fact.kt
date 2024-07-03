package aandrosov.funcatfacts.data.models

import com.google.gson.annotations.SerializedName

data class Fact(
    @SerializedName("_id")
    val id: String,
    val text: String,
    val updatedAt: String,
)

