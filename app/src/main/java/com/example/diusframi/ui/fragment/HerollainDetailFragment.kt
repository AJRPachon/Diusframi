package com.example.diusframi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.diusframi.R
import com.example.diusframi.data.entities.bo.HerollainBo
import com.example.diusframi.databinding.FragmentHerollainDetailBinding
import com.example.diusframi.ui.viewmodel.HerollainDetailViewModel

class HerollainDetailFragment : Fragment() {

    private val viewModel: HerollainDetailViewModel by viewModels()
    private val args: HerollainDetailFragmentArgs by navArgs()

    private var binding: FragmentHerollainDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHerollainDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureObservers()
    }

    private fun configureObservers() {
        viewModel.getHerollainLiveData().observe(viewLifecycleOwner, this::onHerollainLoaded)
        viewModel.requestHerollain(args.id)
    }

    private fun onHerollainLoaded(herollain: HerollainBo) {
        binding?.homeRowLblHerollainNameValue?.text = herollain.name ?: "None"

        binding?.homeRowLblHerollainIntelligenceValue?.text =
            herollain.powerstats?.intelligence?.toString()
        binding?.homeRowLblHerollainStrengthValue?.text = herollain.powerstats?.strength.toString()
        binding?.homeRowLblHerollainSpeedValue?.text = herollain.powerstats?.speed.toString()
        binding?.homeRowLblHerollainDurabilityValue?.text =
            herollain.powerstats?.durability.toString()
        binding?.homeRowLblHerollainPowerValue?.text = herollain.powerstats?.power.toString()
        binding?.homeRowLblHerollainCombatValue?.text = herollain.powerstats?.combat.toString()

        binding?.homeRowLblHerollainGenderValue?.text = herollain.appearances?.gender ?: "None"
        binding?.homeRowLblHerollainRaceValue?.text = herollain.appearances?.race ?: "None"
        binding?.homeRowLblHerollainHeightValue?.text = herollain.appearances?.height ?: "None"
        binding?.homeRowLblHerollainWeightValue?.text = herollain.appearances?.weight ?: "None"
        binding?.homeRowLblHerollainEyecolorValue?.text = herollain.appearances?.eyeColor ?: "None"
        binding?.homeRowLblHerollainHaircolorValue?.text =
            herollain.appearances?.hairColor ?: "None"

        binding?.herollainDetailImgProfilePic?.let {
            Glide.with(requireActivity().applicationContext)
                .load(herollain.images?.lg)
                .error(R.drawable.ic_launcher_background)
                .into(it)
        }

        var favoriteImage = R.drawable.ic__isnofavourite

        if (herollain.isFavorite == true) {
            favoriteImage = R.drawable.ic__isfavourite
        }

        binding?.homeRowImgIsFavourite?.let {
            Glide.with(requireActivity().applicationContext)
                .load(favoriteImage)
                .error(R.drawable.ic_launcher_background)
                .into(it)
        }


        binding?.homeRowImgIsFavourite?.setOnClickListener {
            if (herollain.isFavorite == false) {
                binding?.homeRowImgIsFavourite?.setImageResource(R.drawable.ic__isfavourite)
                herollain.isFavorite = true
            } else {
                binding?.homeRowImgIsFavourite?.setImageResource(R.drawable.ic__isnofavourite)
                herollain.isFavorite = false
            }
            herollain.id?.let { id -> viewModel.setHerollainFavorite(id) }
        }

        binding?.homeRowImgBackArrow?.setOnClickListener {
            findNavController().navigateUp()
        }


    }

}