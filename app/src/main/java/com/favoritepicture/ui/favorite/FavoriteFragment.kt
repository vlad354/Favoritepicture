package com.favoritepicture.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.favoritepicture.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {

    private lateinit var viewModel: FavoriteViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(FavoriteViewModel::class.java)

        val binding = FragmentFavoriteBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        val textView: TextView = binding.textDashboard
        viewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return binding.root
    }


}