package com.example.testlifehackstudio.presentation.company_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testlifehackstudio.R
import com.example.testlifehackstudio.databinding.FragmentCompaniesListBinding

class CompaniesListFragment : Fragment() {

    private val viewModel: CompaniesListViewModel by activityViewModels()
    private lateinit var binding: FragmentCompaniesListBinding
    private lateinit var adapter: CompaniesListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCompaniesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRcAdapter()
        observeCompaniesList()
        observeIsLoading()
    }

    private fun observeIsLoading() {
        binding.swipeToRefresh.setOnRefreshListener {
            viewModel.loadAllCompanies()
        }
        lifecycleScope.launchWhenStarted {
            viewModel.isLoading.collect {
                binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
                binding.swipeToRefresh.isRefreshing = it
            }
        }
    }

    private fun observeCompaniesList() {
        lifecycleScope.launchWhenStarted {
            viewModel.companiesList.collect {
                adapter.submitList(it)
            }
        }
    }

    private fun initRcAdapter() {
        adapter = CompaniesListAdapter(object : CompaniesListAdapter.Listener {
            override fun onItemClicked(id: String) {
                val bundle = bundleOf("id" to id)
                findNavController().navigate(
                    R.id.action_companiesListFragment_to_companyPageFragment,
                    bundle
                )
            }
        })
        binding.rcCompaniesList.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rcCompaniesList.adapter = adapter
    }
}