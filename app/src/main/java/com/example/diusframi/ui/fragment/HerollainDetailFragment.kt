package com.example.diusframi.ui.fragment

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
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
        binding?.herollainDetailLblHerollainNameValue?.text = herollain.name ?: "None"

        binding?.herollainDetailImgProfilePic?.let {
            Glide.with(requireActivity().applicationContext)
                .load(herollain.images?.lg)
                .error(R.drawable.ic_launcher_background)
                .into(it)
        }

        binding?.herollainDetailLblHerollainIntelligenceValue?.text =
            herollain.powerstats?.intelligence?.toString()
        binding?.herollainDetailLblHerollainStrengthValue?.text = herollain.powerstats?.strength.toString()
        binding?.herollainDetailLblHerollainSpeedValue?.text = herollain.powerstats?.speed.toString()
        binding?.herollainDetailLblHerollainDurabilityValue?.text =
            herollain.powerstats?.durability.toString()
        binding?.herollainDetailLblHerollainPowerValue?.text = herollain.powerstats?.power.toString()
        binding?.herollainDetailLblHerollainCombatValue?.text = herollain.powerstats?.combat.toString()

        binding?.herollainDetailLblHerollainGenderValue?.text = herollain.appearances?.gender ?: "None"
        binding?.herollainDetailLblHerollainRaceValue?.text = herollain.appearances?.race ?: "None"
        binding?.herollainDetailLblHerollainHeightValue?.text = herollain.appearances?.height ?: "None"
        binding?.herollainDetailLblHerollainWeightValue?.text = herollain.appearances?.weight ?: "None"
        binding?.herollainDetailLblHerollainEyecolorValue?.text = herollain.appearances?.eyeColor ?: "None"
        binding?.herollainDetailLblHerollainHaircolorValue?.text =
            herollain.appearances?.hairColor ?: "None"

        binding?.herollainDetailPrgbIntelligence?.progress = herollain.powerstats?.intelligence ?: 0
        binding?.herollainDetailPrgbStrength?.progress = herollain.powerstats?.strength ?: 0
        binding?.herollainDetailPrgbSpeed?.progress = herollain.powerstats?.speed ?: 0
        binding?.herollainDetailPrgbDurability?.progress = herollain.powerstats?.durability ?: 0
        binding?.herollainDetailPrgbPower?.progress = herollain.powerstats?.power ?: 0
        binding?.herollainDetailPrgbCombat?.progress = herollain.powerstats?.combat ?: 0


        if (herollain.powerstats?.power != null){
            if(herollain.powerstats.power < 50){
                binding?.herollainDetailPrgbIntelligence?.progressDrawable?.setColorFilter(resources.getColor(R.color.purple_200),
                    PorterDuff.Mode.SRC_IN)
            }
        }
        binding?.herollainDetailPrgbIntelligence?.let {
            herollain.powerstats?.intelligence?.let { value ->
                setProgress(
                    value,
                    it
                )
            }
        }
        binding?.herollainDetailPrgbStrength?.let {
            herollain.powerstats?.strength?.let { value ->
                setProgress(
                    value,
                    it
                )
            }
        }
        binding?.herollainDetailPrgbSpeed?.let {
            herollain.powerstats?.speed?.let { value ->
                setProgress(
                    value,
                    it
                )
            }
        }
        binding?.herollainDetailPrgbDurability?.let {
            herollain.powerstats?.durability?.let { value ->
                setProgress(
                    value,
                    it
                )
            }
        }
        binding?.herollainDetailPrgbPower?.let {
            herollain.powerstats?.power?.let { value ->
                setProgress(
                    value,
                    it
                )
            }
        }
        binding?.herollainDetailPrgbCombat?.let {
            herollain.powerstats?.combat?.let { value ->
                setProgress(
                    value,
                    it
                )
            }
        }

        var favoriteImage = R.drawable.ic__isnofavourite

        if (herollain.isFavorite == true) {
            favoriteImage = R.drawable.ic__isfavourite
        }

        binding?.herollainDetailImgIsFavourite?.let {
            Glide.with(requireActivity().applicationContext)
                .load(favoriteImage)
                .error(R.drawable.ic_launcher_background)
                .into(it)
        }

        binding?.herollainDetailImgIsFavourite?.setOnClickListener {
            if (herollain.isFavorite == false) {
                binding?.herollainDetailImgIsFavourite?.setImageResource(R.drawable.ic__isfavourite)
                herollain.isFavorite = true
            } else {
                binding?.herollainDetailImgIsFavourite?.setImageResource(R.drawable.ic__isnofavourite)
                herollain.isFavorite = false
            }
            herollain.id?.let { id -> viewModel.setHerollainFavorite(id) }
        }

        binding?.herollainDetailImgBackArrow?.setOnClickListener {
            findNavController().navigateUp()
        }

    }

    private fun setProgress(rango : Int, progressBar : ProgressBar){
        when(rango){
            in 0..30-> { progressBar.progressDrawable?.setColorFilter(resources.getColor(R.color.low_stat), PorterDuff.Mode.SRC_IN)}
            in 31..69-> {  progressBar.progressDrawable?.setColorFilter(resources.getColor(R.color.medium_stat), PorterDuff.Mode.SRC_IN) }
            in 70..100-> {  progressBar.progressDrawable?.setColorFilter(resources.getColor(R.color.hight_stat), PorterDuff.Mode.SRC_IN) }
        }
    }

}