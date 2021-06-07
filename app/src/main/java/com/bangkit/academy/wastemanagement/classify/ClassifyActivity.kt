package com.bangkit.academy.wastemanagement.classify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.academy.wastemanagement.R

class ClassifyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classify)


    }

    companion object {
        const val IMAGE_URI = "image_uri"
    }
}