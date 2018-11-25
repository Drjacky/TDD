package ir.hosseinabbasi.tdd.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ir.hosseinabbasi.mvvm.ui.home.AlbumListAdapter
import ir.hosseinabbasi.tdd.R
import ir.hosseinabbasi.tdd.common.applyIoScheduler
import ir.hosseinabbasi.tdd.service.AlbumService
import ir.hosseinabbasi.tdd.service.AlbumServiceImpl
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Dr.jacky on 11/25/2018.
 */
class MainActivity : AppCompatActivity() {

    private val albumService: AlbumService by lazy {
        AlbumServiceImpl()
    }

    private val adapter: AlbumListAdapter by lazy {
        AlbumListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("CheckResult")
    fun searchAlbums(view: View) {
        val search = activityMainBtnSearch.text.toString()

        albumService.getAlbums(search)
            .applyIoScheduler()
            .subscribe(adapter::submitList)
    }
}