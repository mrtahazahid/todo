package com.tahazahid.todo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tahazahid.todo.MyApplication
import com.tahazahid.todo.adapter.BuyListAdapter
import com.tahazahid.todo.databinding.ActivityBuyBinding
import com.tahazahid.todo.viewmodel.BuyViewModel
import com.tahazahid.todo.viewmodel.BuyViewModelFactory

class BuyActivity : AppCompatActivity() {
    private var _binding : ActivityBuyBinding? = null
    private val binding get() = _binding!!
    lateinit var buyViewModel: BuyViewModel
    lateinit var manager : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityBuyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        manager = LinearLayoutManager(this)

        val repository = (application as MyApplication).buyRepository

        buyViewModel = ViewModelProvider(this, BuyViewModelFactory(repository)).get(BuyViewModel::class.java)

        buyViewModel.buyList.observe(this, Observer {
            if(it.isEmpty()){
                binding.progressBar.visibility = View.VISIBLE
            }
            else{
                binding.progressBar.visibility = View.GONE
                binding.recyclerView.apply {
                    adapter = BuyListAdapter(it)
                    layoutManager = manager
                }
            }
        })
    }
}