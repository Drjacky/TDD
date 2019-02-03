package ir.hosseinabbasi.tdd.service

import android.accounts.NetworkErrorException
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import ir.hosseinabbasi.tdd.dto.AlbumDto
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.junit.AfterClass




@RunWith(JUnit4::class)
class TestAlbumService {

    private val albumService: AlbumService by lazy {
        mock(AlbumService::class.java)
    }

    @Before
    @Throws
    fun setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `get list of albums`() {
        val albums = getMockedAlbums(10)

        `when`(albumService.getAlbums("1")).thenReturn(Single.just(albums))
        val result = albumService.getAlbums("1")
        val testObserver = TestObserver<List<AlbumDto>>()

        result.subscribe(testObserver)
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        val listResult = testObserver.values()[0]
        assertThat(listResult.size, `is`(10))
        assertThat(listResult[0].title, `is`("quidem molestiae enim"))
        assertThat(listResult[0].userId.toString(), `is`("1"))
        assertThat(listResult[0].id.toString(), `is`("1"))
    }

    @Test(expected = NetworkErrorException::class)
    fun `get list of albums but network error`() {
        //`when`(albumService.getAlbums("1")).thenThrow(RuntimeException())
        `when`(albumService.getAlbums("1")).thenAnswer { throw NetworkErrorException() }
        albumService.getAlbums("1")
    }

    @After
    fun tearDownClass() {
        // Removes all handlers and resets the default behavior.
        RxAndroidPlugins.reset()
    }

    private fun getMockedAlbums(count: Int): List<AlbumDto> {
        val albums = ArrayList<AlbumDto>()
        for (i in 1..count) {
            //val album = mock(AlbumDto::class.java)
            val album = AlbumDto(i.toLong(), Math.ceil(i / 10.toDouble()).toLong(), "quidem molestiae enim")
            albums.add(album)
        }

        return albums
    }
}