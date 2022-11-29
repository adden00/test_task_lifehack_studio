package com.example.testlifehackstudio.presentation.company_page

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.testlifehackstudio.common.constants.Constants.BASE_URL
import com.example.testlifehackstudio.databinding.FragmentCompanyPageBinding

class CompanyPageFragment : Fragment() {
    private lateinit var binding: FragmentCompanyPageBinding
    private val viewModel: CompanyViewModel by activityViewModels()
    private lateinit var id: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCompanyPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        id = arguments?.getString("id")!!
        loadData()
        observeData()
        observeLoading()
    }

    private fun observeLoading() {
        binding.swipeToRefresh.setOnRefreshListener {
            viewModel.loadCompanyInfo(id)
        }
        lifecycleScope.launchWhenStarted {
            viewModel.isLoading.collect {
                binding.progressBar2.visibility = if (it) View.VISIBLE else View.GONE
                binding.swipeToRefresh.isRefreshing = it
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun observeData() {
        lifecycleScope.launchWhenStarted {
            viewModel.companyInfo.collect { item ->
                item?.let {
                    binding.tvName.text = it.name
                    binding.tvDescription.text = it.description
                    binding.tvContacts.text = "site: ${it.www} \nphone: ${it.phone}"
                    binding.tvLocation.text = "${it.lat},${it.lon}"
                    Glide.with(requireContext()).load("$BASE_URL${it.img}").centerCrop()
                        .into(binding.imageView)
                }
            }
        }
    }

    private fun loadData() {
        viewModel.loadCompanyInfo(id)
    }
}