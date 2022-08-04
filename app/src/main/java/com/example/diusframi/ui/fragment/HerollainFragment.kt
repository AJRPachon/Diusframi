package com.example.diusframi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diusframi.data.entities.bo.HerollainBo
import com.example.diusframi.data.local.repository.LocalRepository
import com.example.diusframi.data.remote.repository.RemoteRepository
import com.example.diusframi.data.remote.repository.GlobalRepository
import com.example.diusframi.databinding.FragmentHomeBinding
import com.example.diusframi.ui.adapter.HerollainAdapter
import com.example.diusframi.ui.adapter.HerollainCallBack
import com.example.diusframi.ui.viewmodel.HerollainViewModel


class HerollainFragment : Fragment() {

    private val viewModel = HerollainViewModel(
        GlobalRepository(
            LocalRepository,
            RemoteRepository()
        )
    )
    private val adapter by lazy {
        HerollainAdapter(
            object : HerollainCallBack.HerollainDetailClickListener{
                override fun onHerollainClicked(herollainId: Int) {
                    val action = HerollainFragmentDirections.actionHomeFragmentToHerollainDetailFragment(herollainId)
                    findNavController().navigate(action)
                }
            }
        )
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
        binding?.homeListHerollainsList?.adapter = adapter
        binding?.homeListHerollainsList?.layoutManager = LinearLayoutManager(
            requireActivity().applicationContext,
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    private fun configureObservers(){
        viewModel.getHerollainLD().observe(viewLifecycleOwner, ::onHerollainsLoaded)
        viewModel.herollainLiveData()
    }

    private fun onHerollainsLoaded(herollainsList : List<HerollainBo>){
        adapter.submitList(herollainsList)

        val herollainNames = mutableListOf<String>()
        herollainsList.forEach {
            it.name?.let { name -> herollainNames.add(name) }
        }

        val adapterAuto = ArrayAdapter(requireContext(), android.R.layout.simple_expandable_list_item_1, herollainNames)
        binding?.homeInputSearchBar?.threshold = 1
        binding?.homeInputSearchBar?.setAdapter(adapterAuto)

        binding?.homeInputSearchBar?.setOnItemClickListener { _, _, _, _ ->
            viewModel.getHerollain().observe(viewLifecycleOwner){
                val mutableList : MutableList<HerollainBo> = mutableListOf(it)
                adapter.submitList(mutableList)
            }
            binding?.homeInputSearchBar?.text?.toString()
                ?.let { name -> viewModel.requestHerollain(name) }
        }

        binding?.homeImgAutocompleteClearIc?.setOnClickListener {
            adapter.submitList(herollainsList)
            binding?.homeInputSearchBar?.setText("")
        }

    }

}