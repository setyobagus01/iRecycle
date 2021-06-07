package com.bangkit.academy.wastemanagement.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.academy.wastemanagement.core.data.DataState
import com.bangkit.academy.wastemanagement.core.ui.home.HomeAdapter
import com.bangkit.academy.wastemanagement.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val homeViewModel: HomeViewModel by viewModels()
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = HomeAdapter()

        homeViewModel.waste.observe(viewLifecycleOwner, { waste ->
            if (waste != null) {
                when (waste) {
                    is DataState.Loading -> {

                    }
                    is DataState.Success -> {

                        adapter.setData(waste.data)
                        Log.d("Data ku", waste.data.toString())

                    }
                    is DataState.Error -> {

                    }
                }

            }
        })

        binding?.rvWasteCategory?.setHasFixedSize(true)
        binding?.rvWasteCategory?.layoutManager = LinearLayoutManager(context)
        binding?.rvWasteCategory?.adapter = adapter

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}