package com.tahazahid.todo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tahazahid.todo.adapter.CallListAdapter
import com.tahazahid.todo.api.ApiInterface
import com.tahazahid.todo.api.ApiUtilities
import com.tahazahid.todo.databinding.ActivityCallBinding
import com.tahazahid.todo.repository.CallRepository
import com.tahazahid.todo.viewmodel.CallViewModel
import com.tahazahid.todo.viewmodel.CallViewModelFactory

class CallActivity : AppCompatActivity() {
    private var _binding : ActivityCallBinding? = null
    private val binding get() = _binding!!
    lateinit var callViewModel: CallViewModel
    lateinit var apiInterface: ApiInterface
    lateinit var callRepository: CallRepository
    lateinit var manager : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCallBinding.inflate(layoutInflater)
        setContentView(binding.root)

        manager = LinearLayoutManager(this)

        apiInterface = ApiUtilities.getInstance().create(ApiInterface::class.java)

        callRepository = CallRepository(apiInterface, this)

        callViewModel = ViewModelProvider(this, CallViewModelFactory(callRepository)).get(CallViewModel::class.java)

        callViewModel.callList.observe(this, Observer {
            binding.recyclerView.apply {
                adapter = CallListAdapter(it)
                layoutManager = manager
            }
        })
    }
}