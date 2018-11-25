package ir.hosseinabbasi.tdd.dao

import io.reactivex.Single
import ir.hosseinabbasi.tdd.dto.AlbumDto
import retrofit2.Retrofit

/**
 * Created by Dr.jacky on 11/25/2018.
 */
class AlbumDaoImpl : AlbumDao {

    private val retrofit: Retrofit by lazy {
        NetDao().provideRetrofit()
    }

    override fun getAlbums(userId: String): Single<List<AlbumDto>> {
        return retrofit.create(AlbumDao::class.java)
            .getAlbums(userId)
    }
}