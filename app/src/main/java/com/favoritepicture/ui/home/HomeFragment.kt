package com.favoritepicture.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.favoritepicture.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val binding = FragmentHomeBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.homeViewModel = homeViewModel

        val adapter = HomeRecyclerAdapter(HomeFavoriteListener { id ->
            Toast.makeText(context, id, Toast.LENGTH_LONG).show()
        })
        binding.recyclerHomeXml.adapter = adapter



        return binding.root
    }
}