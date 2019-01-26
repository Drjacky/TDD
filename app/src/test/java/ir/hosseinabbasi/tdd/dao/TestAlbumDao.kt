package ir.hosseinabbasi.tdd.dao

import ir.hosseinabbasi.tdd.dto.AlbumDto
import org.junit.Before
import org.junit.Test

class TestAlbumDao {

    // define a variable for the Dao we are testing.
    lateinit var albumDao: AlbumDao

    @Before
    fun setup() {

        albumDao = AlbumDaoStubImpl()
        println("Before: running init before EACH tests.")
    }

    @Test
    fun `search for albums should return at least one result`() {

        val albums = albumDao.getAlbums("1")

        albums.test()
            .assertValueCount(1)

        println("TEST: Running AtLeastOneResult test.")
    }

    @Test
    fun `search for first album of user number 1 should return exact result`() {

        val albums = albumDao.getAlbums("1").map { it[0] }
        val albumMocked = AlbumDto(1, 10, "albumNumber1")

        albums.test().assertResult(albumMocked)

        println("TEST: Running Album1ShouldReturnResult test.")
    }
}