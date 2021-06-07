package com.bangkit.academy.wastemanagement.detailresult

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.academy.wastemanagement.core.data.DataState
import com.bangkit.academy.wastemanagement.core.domain.model.Predict
import com.bangkit.academy.wastemanagement.databinding.ActivityDetailResultBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailResult : AppCompatActivity() {

    private val detailResultViewModel: DetailResultViewModel by viewModels()

    private var _binding: ActivityDetailResultBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDetailResultBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val result = intent.getParcelableArrayListExtra<Predict>(EXTRA_DATA)
        val image = intent.getStringExtra(EXTRA_IMAGE)

        binding?.resultPicture?.setImageURI(Uri.parse(image))


        if (result != null) {

            detailResultViewModel.getWasteType(result[0].wasteType.capitalize())
            detailResultViewModel.waste.observe(this, { waste ->
                if (waste != null) {
                    when (waste) {
                        is DataState.Loading -> {

                        }

                        is DataState.Success -> {
                            Log.d("kentulllllllll coook", waste.data.toString())
                        }

                        is DataState.Error -> {

                        }
                    }
                }
            })
        }

        Log.d("bisa coook", result.toString())
    }



    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_IMAGE = "extra_image"
    }
}