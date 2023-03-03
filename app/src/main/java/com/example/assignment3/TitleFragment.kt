package com.example.assignment3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation


class TitleFragment : Fragment() {

    private var navController: NavController ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_title, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.aboutUsButton)?.setOnClickListener{
            navController?.navigate(R.id.action_titleFragment_to_aboutUs)
        }
        view.findViewById<Button>(R.id.task1Button)?.setOnClickListener {
            navController?.navigate(R.id.action_titleFragment_to_viewPagerActivity)
        }
        view.findViewById<Button>(R.id.task2Button)?.setOnClickListener {
            navController?.navigate(R.id.action_titleFragment_to_masterDetailActivity)
        }
    }

}