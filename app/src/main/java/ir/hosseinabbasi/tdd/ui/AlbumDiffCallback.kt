package ir.hosseinabbasi.mvvm.ui.home

import androidx.recyclerview.widget.DiffUtil
import ir.hosseinabbasi.tdd.dto.AlbumDto

/**
 * Created by Dr.jacky on 11/25/2018.
 */
class AlbumDiffCallback : DiffUtil.ItemCallback<AlbumDto>() {

    override fun areItemsTheSame(oldItem: AlbumDto, newItem: AlbumDto): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: AlbumDto, newItem: AlbumDto): Boolean =
        oldItem == newItem

    override fun getChangePayload(oldItem: AlbumDto, newItem: AlbumDto): Any? {
        // Return particular field for changed item.
        return super.getChangePayload(oldItem, newItem)
    }
}