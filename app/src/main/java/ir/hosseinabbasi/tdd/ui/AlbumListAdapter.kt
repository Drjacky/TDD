package ir.hosseinabbasi.mvvm.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ir.hosseinabbasi.tdd.R
import ir.hosseinabbasi.tdd.databinding.ItemAlbumBinding
import ir.hosseinabbasi.tdd.dto.AlbumDto

/**
 * Created by Dr.jacky on 11/25/2018.
 */
class AlbumListAdapter : ListAdapter<AlbumDto, AlbumListAdapter.DataHolder>(AlbumDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val bind: ItemAlbumBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_album, parent, false
        ) as ItemAlbumBinding

        return DataHolder(bind)
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val album = getItem(position)
        album?.let { holder.bind(album) }
    }

    inner class DataHolder(private var itemAlbumBinding: ItemAlbumBinding) : RecyclerView.ViewHolder
        (itemAlbumBinding.root) {

        fun bind(albumItem: AlbumDto) {
            itemAlbumBinding.albumDto = albumItem
            itemAlbumBinding.executePendingBindings()
        }
    }
}