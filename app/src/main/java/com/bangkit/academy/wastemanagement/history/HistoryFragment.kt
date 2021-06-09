package com.bangkit.academy.wastemanagement.history

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bangkit.academy.wastemanagement.core.data.DataState
import com.bangkit.academy.wastemanagement.core.ui.history.HistoryAdapter
import com.bangkit.academy.wastemanagement.databinding.FragmentHistoryBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private val historyViewModel: HistoryViewModel by viewModels()
    private lateinit var adapter: HistoryAdapter

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HistoryAdapter()
        historyViewModel.history.observe(viewLifecycleOwner, { history ->
            if (history != null) {
                when (history) {
                    is DataState.Loading -> {

                    }
                    is DataState.Success -> {
                        Log.d("awdawdaw", history.data.toString())
                        adapter.setData(history.data)
                    }
                    is DataState.Error -> {

                    }

                }
            }
        })

        binding?.rvHistory?.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding?.rvHistory?.adapter = adapter
        binding?.rvHistory?.setHasFixedSize(true)

    }
    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)


        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val movie = adapter.getSwipedData(swipedPosition)
                movie?.let { historyViewModel.deleteHistory(it) }

                val snackbar = Snackbar.make(view as View, "Undo Delete", Snackbar.LENGTH_SHORT)
                snackbar.setAction("Ok") { _ ->
                    movie?.let { historyViewModel.deleteHistory(it) }
                }
                snackbar.show()
            }
        }

    })
}