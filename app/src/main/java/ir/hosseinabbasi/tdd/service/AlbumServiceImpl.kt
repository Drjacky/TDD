package ir.hosseinabbasi.tdd.service

import io.reactivex.Single
import ir.hosseinabbasi.tdd.dao.AlbumDao
import ir.hosseinabbasi.tdd.dao.AlbumDaoImpl
import ir.hosseinabbasi.tdd.dto.AlbumDto

/**
 * Created by Dr.jacky on 11/25/2018.
 */
class AlbumServiceImpl : AlbumService {

    private val albumDao: AlbumDao by lazy {
        AlbumDaoImpl()
    }

    override fun getAlbums(userId: String): Single<List<AlbumDto>> {
        return albumDao.getAlbums(userId)
    }
}