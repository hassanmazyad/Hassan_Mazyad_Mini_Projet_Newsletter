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
import com.example.newsletter.adapters.CallBack
import com.example.newsletter.adapters.CategoriesAdapter
import com.example.newsletter.adapters.CountryAdapter
import com.example.newsletter.data.Category
import com.example.newsletter.data.Country

/**
 * A simple [Fragment] subclass.
 * Use the [CountriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CountriesFragment : Fragment(), CallBack {
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view)
        val countries = listOf<Country>(
            Country("France", "https://upload.wikimedia.org/wikipedia/commons/c/c3/Flag_of_France.svg"),
            Country("Chine", "https://images-na.ssl-images-amazon.com/images/I/21AdMPSfywL._AC_SX425_.jpg"),
            Country("Etats Unis", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fdrapeau.biz%2Famerique%2Fdrapeau-usa%2F&psig=AOvVaw0laRzNX4IIebOIvrmtYRvg&ust=1606068443167000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCPjItqqdlO0CFQAAAAAdAAAAABAG"),
            Country("Angleterre", "https://upload.wikimedia.org/wikipedia/commons/a/ae/Flag_of_the_United_Kingdom.svg"),
            Country("Italie", "https://upload.wikimedia.org/wikipedia/commons/0/03/Flag_of_Italy.svg"),
        )

        val adapterRecycler = CountryAdapter(countries, this)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = adapterRecycler

    }

    override fun onClick(myCountry: String) {
        (activity as? MainActivity)?.changeFragment(ArticleFragment.newInstance(myCountry))
    }
}
