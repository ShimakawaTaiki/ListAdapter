package com.example.listadapter.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.listadapter.databinding.FragmentMainBinding
import com.example.listadapter.main.data.Prefecture
import com.example.listadapter.main.viewmodel.MainViewModel

class MainFragment: Fragment() {
    private val viewModel: MainViewModel by viewModels()
    lateinit var adapter: PrefectureListAdapter
    lateinit var binding: FragmentMainBinding

    /**
     * fragmentレイアウトをviewの初期化後、反映する。
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewModel = viewModel

        adapter = PrefectureListAdapter(viewModel, viewLifecycleOwner)
        binding.recyclerview.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.prefectures.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })

        viewModel.click.observe(viewLifecycleOwner, {
            viewModel.selected?.let { selected ->
                Toast.makeText(requireActivity(), selected, Toast.LENGTH_SHORT).show()
            }
        })
    }
}