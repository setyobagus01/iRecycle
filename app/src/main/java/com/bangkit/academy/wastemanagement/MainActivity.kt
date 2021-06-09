package com.bangkit.academy.wastemanagement

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toFile
import com.bangkit.academy.wastemanagement.core.data.DataState
import com.bangkit.academy.wastemanagement.core.domain.model.Predict
import com.bangkit.academy.wastemanagement.databinding.ActivityMainBinding
import com.bangkit.academy.wastemanagement.detailresult.DetailResult
import com.bangkit.academy.wastemanagement.history.HistoryFragment
import com.bangkit.academy.wastemanagement.home.HomeFragment
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding

    private val mainViewModel: MainViewModel by viewModels()

    private var imageFile: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        val toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        actionBar?.elevation = 0f

        supportFragmentManager.beginTransaction()
            .add(R.id.nav_host_fragment, HomeFragment())
            .commit()

        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment, HomeFragment())
                        .addToBackStack(null)
                        .commit()
                    true

                }
                R.id.navigation_notifications -> {

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment, HistoryFragment())
                        .addToBackStack(null)
                        .commit()
                    true

                }
                else -> false


            }
        }

        supportActionBar?.title = "3R Waste"

        binding?.fab?.setOnClickListener {
            openCamera()
        }


    }

    private fun openCamera() {
        ImagePicker.with(this)
            .crop()
            .compress(1024)//User can only capture image using Camera
            .setImageProviderInterceptor { imageProvider -> //Intercept ImageProvider
                Log.d("ImagePicker", "Selected ImageProvider: " + imageProvider.name)
            }
            .setDismissListener {
                // Handle dismiss event
                Log.d("ImagePicker", "onDismiss");
            }
            .createIntent { intent ->
                startForProfileImageResult.launch(intent)
            }
    }

    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            when (resultCode) {
                Activity.RESULT_OK -> {
                    //Image Uri will not be null for RESULT_OK
                    val fileUri = data?.data!!
                    mainViewModel.getFile(fileUri.toFile())
                    imageFile = fileUri
                    Log.d("Yay Succeed", imageFile.toString())

                }
                ImagePicker.RESULT_ERROR -> {
                    Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
                }
            }

            mainViewModel.predict.observe(this, { results ->
                if (results != null) {
                    when (results) {
                        is DataState.Loading -> {
                            Toast.makeText(this@MainActivity, "Upload", Toast.LENGTH_SHORT).show()

                        }
                        is DataState.Success -> {
                            val intent = Intent(this@MainActivity, DetailResult::class.java).apply {
                                putParcelableArrayListExtra(
                                    DetailResult.EXTRA_DATA,
                                    results.data as ArrayList<Predict>
                                )
                                putExtra(DetailResult.EXTRA_IMAGE, imageFile.toString())
                            }
                            startActivity(intent)
                        }

                        is DataState.Error -> {

                        }
                    }
                }
            })
        }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val EXTRA_FRAGMENT = "extra_fragment"
        const val EXTRA_TYPE = "extra_type"
    }


}