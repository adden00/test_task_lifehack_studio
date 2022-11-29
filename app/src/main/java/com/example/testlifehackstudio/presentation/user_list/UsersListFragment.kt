package com.example.testlifehackstudio.presentation.user_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testlifehackstudio.databinding.FragmentUsersListBinding

class UsersListFragment: Fragment() {

    private val viewModel: UsersListViewModel by activityViewModels()
    private lateinit var binding: FragmentUsersListBinding
    private lateinit var adapter: UsersListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsersListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRcAdapter()
        observeUsersList()
        observeIsLoading()
    }

    private fun observeIsLoading() {
        lifecycleScope.launchWhenStarted {
            viewModel.isLoading.collect {
                binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
            }
        }
    }

    private fun observeUsersList() {
        lifecycleScope.launchWhenStarted {
            viewModel.usersList.collect {
                adapter.submitList(it)
            }
        }
    }

    private fun initRcAdapter() {
        adapter = UsersListAdapter()
        binding.rcUsersList.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rcUsersList.adapter = adapter
    }

}