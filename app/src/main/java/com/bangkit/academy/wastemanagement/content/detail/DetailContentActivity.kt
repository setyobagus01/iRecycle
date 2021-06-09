package com.bangkit.academy.wastemanagement.content.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.academy.wastemanagement.core.domain.model.Content
import com.bangkit.academy.wastemanagement.databinding.ActivityDetailContentBinding
import com.bumptech.glide.Glide

class DetailContentActivity : AppCompatActivity() {

    private var _binding: ActivityDetailContentBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailContentBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val data = intent.getParcelableExtra<Content>(EXTRA_CONTENT)
        if (data != null) {
            binding?.contentTitle?.text = data.titleContent
            binding?.contentType?.text = data.wasteType
            binding?.contentText?.text = data.content
            binding?.let {
                Glide.with(this)
                    .load(data.imageUrl)
                    .into(it.contentImage)
            }
        }

        binding?.topAppBar?.setNavigationOnClickListener {
            finish()
        }

    }

    companion object {
        const val EXTRA_CONTENT = "extra_content"
    }
}