package ir.hosseinabbasi.tdd.dao

import io.reactivex.observers.TestObserver
import ir.hosseinabbasi.tdd.Utils.Companion.getJson
import ir.hosseinabbasi.tdd.dto.AlbumDto
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@RunWith(JUnit4::class)
class TestAlbumDaoViaMockWebService {

    lateinit var albumDao: AlbumDao
    lateinit var mockWebServer: MockWebServer

    @Before
    @Throws
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        val okHttpClient = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(mockWebServer.url("/").toString())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        albumDao = retrofit.create(AlbumDao::class.java)
    }

    @Test
    fun `get list of albums from mocked server`() {
        val testObserver = TestObserver<List<AlbumDto>>()
        val path = "/albums?userId="
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(getJson("json/albums.json"))

        mockWebServer.enqueue(mockResponse)
        albumDao.getAlbums("").subscribe(testObserver)
        testObserver.awaitTerminalEvent(2, TimeUnit.SECONDS)

        testObserver.assertNoErrors()
        testObserver.assertValueCount(1) //Cause one list returned

        val request = mockWebServer.takeRequest()

        assertEquals(path, request.path)
    }

    @After
    @Throws
    fun tearDown() {
        mockWebServer.shutdown()
    }
}