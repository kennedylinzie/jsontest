package com.example.apitest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.apitest.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso


class detail : Fragment() {

private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        val fullname = activity?.intent?.getStringExtra("login")
        val repo = activity?.intent?.getStringExtra("reposUrl")
        val type = activity?.intent?.getStringExtra("type")
        val avatar = activity?.intent?.getStringExtra("avatarUrl")

        if (fullname != null) {
            binding.tvFullname.text = fullname
        }
        if (repo != null) {
            binding.tvDetailRepo.text = repo
        }
        if (type != null) {
            binding.tvDetailType.text = type
        }
        if (avatar != null) {
            Picasso.get().load(avatar).into(binding.detailAvatar)
        }
        binding.curvedButton.setOnClickListener {

            val navController = findNavController()
            navController.navigate(R.id.more_detail)

        }

        return binding.root
    }

}