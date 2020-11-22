package com.example.newsletter.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsletter.MainActivity
import com.example.newsletter.R
import com.example.newsletter.adapters.CallBack
import com.example.newsletter.adapters.CategoriesAdapter
import com.example.newsletter.data.Category

/**
 * A simple [Fragment] subclass.
 * Use the [AProposDeNous.newInstance] factory method to
 * create an instance of this fragment.
 */
class AProposDeNous : Fragment(){

    companion object {
        fun newInstance(aProposDeNous: String): AProposDeNous {
            return AProposDeNous().apply {}
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.a_propos_de_nous, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
