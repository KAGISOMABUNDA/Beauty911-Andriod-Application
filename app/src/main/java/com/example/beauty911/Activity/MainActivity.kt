package com.example.beauty911.Activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beauty911.Adapter.TopDoctorAdapter
import com.example.beauty911.ViewModel.MainViewModel
import com.example.beauty911.adapter.CategoryAdapter
import com.example.beauty911.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCategory()
        initTopDoctors()

    }

    private fun initTopDoctors() {
        binding.apply {
            progressBarTopDoctor.visibility= View.VISIBLE
            viewModel.doctors.observe(this@MainActivity, Observer {
                recyclerViewTopDoctor.layoutManager= LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL, false)
                recyclerViewTopDoctor.adapter= TopDoctorAdapter(it)
                progressBarTopDoctor.visibility= View.GONE
            })
            viewModel.loadCategory()
        }
    }

    private fun initCategory() {
        binding.progressBarCategory.visibility = View.VISIBLE
        viewModel.category.observe(this, Observer {
            binding.viewCategory.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            binding.viewCategory.adapter = CategoryAdapter(it)
            binding.progressBarCategory.visibility = View.GONE
        })
        viewModel.loadCategory()
    }
}
