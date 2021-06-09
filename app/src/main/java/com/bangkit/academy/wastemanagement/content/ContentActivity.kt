package com.bangkit.academy.wastemanagement.content

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.academy.wastemanagement.MainActivity
import com.bangkit.academy.wastemanagement.content.detail.DetailContentActivity
import com.bangkit.academy.wastemanagement.core.data.DataState
import com.bangkit.academy.wastemanagement.core.ui.content.ContentAdapter
import com.bangkit.academy.wastemanagement.databinding.ActivityContentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContentActivity : AppCompatActivity() {

    private var _binding: ActivityContentBinding? = null
    private val binding get() = _binding
    private lateinit var adapter: ContentAdapter
    private val contentViewModel: ContentViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        adapter = ContentAdapter()


        val extraType = intent.getStringExtra(MainActivity.EXTRA_TYPE)
        if (extraType != null) {
            Log.d("erororo ororo", extraType)
            contentViewModel.getWasteType(extraType)
            contentViewModel.content.observe(this, { content ->
                if (content != null) {
                    when (content) {
                        is DataState.Loading -> {

                        }
                        is DataState.Success -> {
                            adapter.setContent(content.data)


                        }
                        is DataState.Error -> {


                        }
                    }
                }
            })
            adapter.onItemClick = { selectedData ->
                val intent = Intent(this, DetailContentActivity::class.java).apply {
                    putExtra(DetailContentActivity.EXTRA_CONTENT, selectedData)
                }
                startActivity(intent)
            }

        }

        binding?.topAppBar?.setNavigationOnClickListener {
            finish()
        }


        binding?.rvContent?.layoutManager = LinearLayoutManager(this)
        binding?.rvContent?.adapter = adapter
        binding?.rvContent?.setHasFixedSize(true)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val EXTRA_TYPE = "extra_type"
    }
}