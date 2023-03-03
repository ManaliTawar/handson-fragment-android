package com.example.assignment3

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class MovieListFragment : Fragment() {
    private var listener: OnMasterDetailListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movie1 = view.findViewById<Button>(R.id.movie1)
        val movie2 = view.findViewById<Button>(R.id.movie2)
        val movie3 = view.findViewById<Button>(R.id.movie3)

        movie1.setOnClickListener { onClicked(0) }
        movie2.setOnClickListener { onClicked(1)  }
        movie3.setOnClickListener { onClicked(2)  }


    }

    private fun onClicked(position : Int) {
        listener?.onSelect(position)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }


    interface OnMasterDetailListener {
        fun onSelect(position: Int)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnMasterDetailListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnMasterDetailListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

}