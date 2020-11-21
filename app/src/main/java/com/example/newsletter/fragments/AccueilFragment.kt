package com.example.newsletter.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsletter.MainActivity
import com.example.newsletter.R
import com.example.newsletter.adapters.AccueilAdapter
import com.example.newsletter.adapters.CallBack
import com.example.newsletter.data.Section

/**
 * A simple [Fragment] subclass.
 * Use the [AccueilFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccueilFragment : Fragment(), CallBack {
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.accueil_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view)
        val sections = listOf<Section>(
            Section("Categories", "https://previews.123rf.com/images/vectorikart/vectorikart1401/vectorikart140100009/25097410-ensemble-d-ic%C3%B4nes-d-%C3%A9ducation-plats-de-diff%C3%A9rents-sujets-et-concepts.jpg"),
            Section("Editors", "https://previews.123rf.com/images/georgidimitrov70/georgidimitrov701605/georgidimitrov70160500013/55918552-major-journaux-internationaux-d%C3%A9tail-des-en-t%C3%AAtes.jpg"),
            Section("Countries","https://i.ytimg.com/vi/c36MyeomWMs/maxresdefault.jpg")
        )

        val adapterRecycler = AccueilAdapter(sections, this)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = adapterRecycler

    }

    override fun onClick(mySections: String) {
        (activity as? MainActivity)?.changeFragment(CategoriesFragment.newInstance(mySections))
    }
}
