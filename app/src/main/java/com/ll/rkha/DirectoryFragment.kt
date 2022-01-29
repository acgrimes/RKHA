package com.ll.rkha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ll.rkha.databinding.FragmentDirectoryBinding

class DirectoryFragment : Fragment() {
    private var _binding: FragmentDirectoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDirectoryBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val dao = DirectoryItemDatabase.getInstance(application).directoryItemDao
        val viewModelFactory = DirectoryItemViewModelFactory(dao)
        val viewModel = ViewModelProvider(
            this, viewModelFactory).get(DirectoryViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = DirectoryItemAdapter {
            directoryItemId ->  Toast.makeText(context,
                         "Clicked directory profile Id $directoryItemId",
                              Toast.LENGTH_SHORT).show()
        }
        binding.directoriesList.adapter = adapter

        viewModel.directoryItems.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}