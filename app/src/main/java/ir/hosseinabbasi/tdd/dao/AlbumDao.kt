package ir.hosseinabbasi.tdd.dao

import io.reactivex.Single
import ir.hosseinabbasi.tdd.dto.AlbumDto

/**
 * Created by Dr.jacky on 11/25/2018.
 */
interface AlbumDao {

    fun getAlbums(): Single<List<AlbumDto>>

    fun getAlbum(albumId: Int): Single<AlbumDto>
}