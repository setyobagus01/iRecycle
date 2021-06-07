package com.bangkit.academy.wastemanagement.core.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.academy.wastemanagement.core.domain.model.Waste
import com.bangkit.academy.wastemanagement.databinding.WasteItemBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var wasteList = ArrayList<Waste>()
    var onItemClick: ((Waste) -> Unit)? = null

    fun setData(newListData: List<Waste>?) {
        if (newListData == null) return
        wasteList.clear()
        wasteList.addAll(newListData)
        notifyDataSetChanged()
    }


    inner class HomeViewHolder(private val binding: WasteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(waste: Waste) {
            with(binding) {
                wasteName.text = waste.wasteType
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(wasteList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = WasteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val waste = wasteList[position]
        holder.bind(waste)
    }

    override fun getItemCount(): Int = wasteList.size
}