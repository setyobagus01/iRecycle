package com.bangkit.academy.wastemanagement.core.ui.content

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.academy.wastemanagement.core.domain.model.Content
import com.bangkit.academy.wastemanagement.databinding.ContentItemBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ContentAdapter: RecyclerView.Adapter<ContentAdapter.ContentViewHolder>() {

    private val contentList = ArrayList<Content>()
    var onItemClick: ((Content) -> Unit)? = null

    fun setContent(content: List<Content>?) {
        if (content == null) return
        contentList.clear()
        contentList.addAll(content)
        notifyDataSetChanged()
    }

    inner class ContentViewHolder(private val binding: ContentItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(content: Content) {
            with(binding) {
                contentTitle.text = content.titleContent
                Glide.with(itemView.context)
                    .load(content.imageUrl)
                    .apply(RequestOptions.overrideOf(80, 80))
                    .into(contentImage)
                contentText.text = content.content
            }

        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(contentList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val binding = ContentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        val content = contentList[position]
        holder.bind(content)
    }

    override fun getItemCount(): Int = contentList.size
}

