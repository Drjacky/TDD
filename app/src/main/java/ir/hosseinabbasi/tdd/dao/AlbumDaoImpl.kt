package ir.hosseinabbasi.tdd.dao

import io.reactivex.Single
import ir.hosseinabbasi.tdd.dto.AlbumDto

/**
 * Created by Dr.jacky on 11/25/2018.
 */
class AlbumDaoImpl : AlbumDao {

    override fun getAlbums(): Single<List<AlbumDto>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAlbum(albumId: Int): Single<AlbumDto> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}