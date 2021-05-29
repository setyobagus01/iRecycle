package com.bangkit.academy.wastemanagement.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.academy.wastemanagement.data.source.local.entity.WasteEntity
import com.bangkit.academy.wastemanagement.databinding.WasteItemBinding

class HomeAdapter : PagedListAdapter<WasteEntity, HomeAdapter.HomeViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<WasteEntity>() {
            override fun areItemsTheSame(oldItem: WasteEntity, newItem: WasteEntity): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: WasteEntity, newItem: WasteEntity): Boolean =
                oldItem == newItem


        }
    }

    inner class HomeViewHolder(private val binding: WasteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(waste: WasteEntity) {
            with(binding) {
                wasteName.text = waste.className
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = WasteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val waste = getItem(position)
        if (waste != null) {
            holder.bind(waste)
        }
    }

}