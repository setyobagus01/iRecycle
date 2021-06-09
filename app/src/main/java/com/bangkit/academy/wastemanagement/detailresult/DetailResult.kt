package com.bangkit.academy.wastemanagement.detailresult

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.academy.wastemanagement.MainActivity
import com.bangkit.academy.wastemanagement.R
import com.bangkit.academy.wastemanagement.content.ContentActivity
import com.bangkit.academy.wastemanagement.core.data.DataState
import com.bangkit.academy.wastemanagement.core.domain.model.Predict
import com.bangkit.academy.wastemanagement.databinding.ActivityDetailResultBinding
import dagger.hilt.android.AndroidEntryPoint
import java.math.BigDecimal
import java.math.RoundingMode

@AndroidEntryPoint
class DetailResult : AppCompatActivity() {

    private val detailResultViewModel: DetailResultViewModel by viewModels()

    private var _binding: ActivityDetailResultBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDetailResultBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.circularProgressBar1?.progress = 0f

        val result = intent.getParcelableArrayListExtra<Predict>(EXTRA_DATA)
        val image = intent.getStringExtra(EXTRA_IMAGE)



        binding?.resultPicture?.setImageURI(Uri.parse(image))



        if (result != null) {

            val filteredResult = result.maxByOrNull { it.prediction }

            Log.d("awdawd", filteredResult.toString())

            if (filteredResult != null) {
                binding?.result1?.text = filteredResult.wasteType.capitalize()
                binding?.circularProgressBar1?.setProgressWithAnimation(
                    filteredResult.prediction,
                    5000L,
                    null,
                    3000L
                )
                binding?.modelPercentage1?.text = getString(
                    R.string.percent,
                    BigDecimal(filteredResult.prediction.toDouble()).setScale(
                        2,
                        RoundingMode.HALF_EVEN
                    )
                ).replace("\\s".toRegex(), "")


                detailResultViewModel.getWasteType(filteredResult.wasteType.capitalize())
                if (image != null) {
                    detailResultViewModel.savedToHistory(filteredResult, image)
                }

                detailResultViewModel.waste.observe(this, { waste ->
                    if (waste != null) {
                        when (waste) {
                            is DataState.Loading -> {

                            }

                            is DataState.Success -> {
                                binding?.wasteType?.text = waste.data?.wasteType
                                binding?.wasteDescription?.text = waste.data?.description


                            }

                            is DataState.Error -> {

                            }
                        }
                    }
                })

                binding?.btnSubmit?.setOnClickListener {

                    val intent = Intent(this, ContentActivity::class.java).apply {
                        putExtra(ContentActivity.EXTRA_TYPE, filteredResult.wasteType.capitalize())
                    }
                    startActivity(intent)

                }

            }
        }
        binding?.topAppBar?.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_IMAGE = "extra_image"
    }
}