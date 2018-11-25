package ir.hosseinabbasi.tdd.dao

import io.reactivex.Single
import ir.hosseinabbasi.tdd.dto.AlbumDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Dr.jacky on 11/25/2018.
 */
interface AlbumDao {

    @GET("albums")
    fun getAlbums(@Query("userId") userId: Int): Single<List<AlbumDto>>
}