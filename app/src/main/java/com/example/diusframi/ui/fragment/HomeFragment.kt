package com.example.diusframi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diusframi.databinding.FragmentHomeBinding
import com.example.diusframi.ui.adapter.HerollainsAdapter

class HomeFragment : Fragment() {

    private val herollainsAdapter by lazy {
        HerollainsAdapter()
    }

    private var binding : FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureBindings()
        configureObservers()
    }

    private fun configureBindings(){
        binding?.homeListHerollainsList?.adapter = herollainsAdapter
        binding?.homeListHerollainsList?.layoutManager = LinearLayoutManager(
            requireActivity().applicationContext,
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    private fun configureObservers(){

        //TODO Crear observers Home
    }

}