package com.homework.task2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.homework.task2.databinding.FragmentMainBinding

class VideoFragment: Fragment(R.layout.fragment_videos) {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        with(binding){
            btnMusic.setOnClickListener{
                findNavController().navigate(R.id.action_videoFragment_to_musicFragment)
                MusicFragment.createBundle((etText.text?: "Error").toString())
            }
        }
    }
}