package com.bangkit.academy.wastemanagement

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        actionBar?.elevation = 0f

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        supportActionBar?.title = "3R Waste"

        // Action Bar
//        val callback = object : ActionMode.Callback {
//
//            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
//                menuInflater.inflate(R.menu.contextual_action_bar, menu)
//                return true
//            }
//
//            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
//                return false
//            }
//
//            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
//                return when (item?.itemId) {
//                    R.id.share -> {
//                        // Handle share icon press
//                        true
//                    }
//                    R.id.delete -> {
//                        // Handle delete icon press
//                        true
//                    }
//                    R.id.more -> {
//                        // Handle more item (inside overflow menu) press
//                        true
//                    }
//                    else -> false
//                }
//            }
//
//            override fun onDestroyActionMode(mode: ActionMode?) {
//            }
//        }
//
//        val actionMode = startSupportActionMode(callback)
//        actionMode?.title = "1 selected"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


}