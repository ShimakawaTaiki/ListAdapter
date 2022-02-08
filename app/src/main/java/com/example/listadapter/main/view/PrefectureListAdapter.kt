package com.example.listadapter.main.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listadapter.databinding.PrefectureItemBinding
import com.example.listadapter.main.data.Prefecture
import com.example.listadapter.main.viewmodel.MainViewModel

/**
 * 都道府県を表示するリストアダプター
 */
class PrefectureListAdapter(private val viewModel: MainViewModel, private val lifecycleOwner: LifecycleOwner): ListAdapter<Prefecture, PrefectureListAdapter.PrefectureListViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrefectureListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PrefectureItemBinding.inflate(layoutInflater, parent, false)
        return PrefectureListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PrefectureListViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current, viewModel, lifecycleOwner)

        holder.binding.executePendingBindings()
    }

    class PrefectureListViewHolder(val binding: PrefectureItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Prefecture, viewModel: MainViewModel, lifecycleOwner: LifecycleOwner) {
            binding.let {
                it.prefecture = item
                it.viewmodel = viewModel
                it.lifecycleOwner = lifecycleOwner

                it.executePendingBindings()
            }
        }
    }

    private object DiffCallback: DiffUtil.ItemCallback<Prefecture>() {
        override fun areContentsTheSame(oldItem: Prefecture, newItem: Prefecture): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: Prefecture, newItem: Prefecture): Boolean {
            return oldItem.name == newItem.name
        }
    }
}