package com.bangkit.academy.wastemanagement.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bangkit.academy.wastemanagement.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Action Bar
//        val callback = object : ActionMode.Callback {
//
//            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
//                menuInflater.inflate(R.menu.detail_menu, menu)
//                return true
//            }
//
//            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
//                return false
//            }
//
//            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
//                return when (item?.itemId) {
//                    R.id.action_back -> {
//                        // Handle share icon press
//                        true
//                    }
//                    R.id.action_settings -> {
//                        // Handle delete icon press
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


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}