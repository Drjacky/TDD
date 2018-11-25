package ir.hosseinabbasi.tdd.dao

import io.reactivex.Single
import ir.hosseinabbasi.tdd.dto.AlbumDto

/**
 * Created by Dr.jacky on 11/25/2018.
 */
class AlbumDaoStubImpl : AlbumDao {

    override fun getAlbums(userId: String): Single<List<AlbumDto>> {
        val albums = ArrayList<AlbumDto>()
        val album = AlbumDto(
            1,
            10,
            "albumNumber1"
        )

        albums.add(album)
        return Single.just(albums)
    }
}