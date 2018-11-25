package ir.hosseinabbasi.tdd.service

import io.reactivex.Single
import ir.hosseinabbasi.tdd.dto.AlbumDto
import retrofit2.http.Query

/**
 * Created by Dr.jacky on 11/25/2018.
 */
interface AlbumService {

    fun getAlbums(@Query("userId") userId: Int): Single<List<AlbumDto>>
}