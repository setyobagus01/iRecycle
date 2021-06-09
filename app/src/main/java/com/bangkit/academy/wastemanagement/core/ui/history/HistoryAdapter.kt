package com.bangkit.academy.wastemanagement.core.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.academy.wastemanagement.core.domain.model.History
import com.bangkit.academy.wastemanagement.databinding.HistoryItemBinding
import com.bumptech.glide.Glide

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    private val histories = ArrayList<History>()

    fun setData(data: List<History>?) {
        if (data == null) return
        histories.clear()
        histories.addAll(data)
        notifyDataSetChanged()
    }

    inner class HistoryViewHolder(private val binding: HistoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind (history: History) {
                with(binding) {
                    Glide.with(itemView.context)
                        .load(history.imageUrl)
                        .into(imagePrediction)
                }
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = HistoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val history = histories[position]
        holder.bind(history)
    }

    override fun getItemCount(): Int = histories.size

    fun getSwipedData(swipedPosition: Int): History? = histories[swipedPosition]
}