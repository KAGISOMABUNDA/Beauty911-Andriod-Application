package com.example.beauty911.Activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beauty911.Adapter.TopDoctorAdapter
import com.example.beauty911.Adapter.TopDoctorAdapter2
import com.example.beauty911.R
import com.example.beauty911.ViewModel.MainViewModel
import com.example.beauty911.databinding.ActivityTopDoctorsBinding

class TopDoctorsActivity : BaseActivity() {
    private lateinit var binding: ActivityTopDoctorsBinding
    private lateinit var viewModel: MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
        binding=ActivityTopDoctorsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTopDoctors()

    }

    private fun initTopDoctors() {
        binding.apply {
            progressBarTopDoctor.visibility= View.VISIBLE
            viewModel.doctors.observe(this@TopDoctorsActivity, Observer {
                viewTopDoctorList.layoutManager=
                    LinearLayoutManager(this@TopDoctorsActivity, LinearLayoutManager.VERTICAL, false)
                viewTopDoctorList.adapter= TopDoctorAdapter2(it)
                progressBarTopDoctor.visibility= View.GONE
            })
            viewModel.loadCategory()


            backBtn.setOnClickListener { finish()}

        }
    }
}