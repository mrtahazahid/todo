package com.tahazahid.todo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tahazahid.todo.MyApplication
import com.tahazahid.todo.adapter.SellListAdapter
import com.tahazahid.todo.databinding.ActivitySellBinding
import com.tahazahid.todo.viewmodel.SellViewModel
import com.tahazahid.todo.viewmodel.SellViewModelFactory

class SellActivity : AppCompatActivity() {
    private var _binding: ActivitySellBinding? = null
    private val binding get() = _binding!!
    lateinit var sellViewModel: SellViewModel
    lateinit var manager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySellBinding.inflate(layoutInflater)
        setContentView(binding.root)

        manager = LinearLayoutManager(this)

        val repository = (application as MyApplication).sellRepository

        sellViewModel =
            ViewModelProvider(this, SellViewModelFactory(repository)).get(SellViewModel::class.java)

        sellViewModel.sellList.observe(this, Observer {
            if (it.isEmpty()) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
                binding.recyclerView.apply {
                    adapter = SellListAdapter(it)
                    layoutManager = manager
                }
            }
        })
    }
}