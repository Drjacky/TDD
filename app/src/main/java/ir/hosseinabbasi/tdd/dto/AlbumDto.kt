package ir.hosseinabbasi.tdd.dto

import com.google.gson.annotations.SerializedName

/**
 * Created by Dr.jacky on 11/25/2018.
 */
data class AlbumDto(

    @SerializedName("id")
    val id: Long,
    @SerializedName("userId")
    val userId: Long,
    @SerializedName("title")
    val title: String
)