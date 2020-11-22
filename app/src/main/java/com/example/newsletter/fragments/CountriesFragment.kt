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
import com.example.newsletter.adapters.CountryAdapter
import com.example.newsletter.data.Country

/**
 * A simple [Fragment] subclass.
 * Use the [CountriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CountriesFragment : Fragment(), CallBack {
    lateinit var recyclerView: RecyclerView

    private lateinit var countryName: String

    companion object {
        fun newInstance(countryName: String): CountriesFragment {
            return CountriesFragment().apply {
                this.countryName = countryName
            }
        }
    }

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
            Country("fr", "https://www.autocollants-stickers.com/resize/360x360/zc/3/f/0/src/sites/astickers/files/products/f59efdba4d35f58bb95339edcc5b0f10.png"),
            Country("cn", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Zeng_Liansong%27s_proposal_for_the_PRC_flag.svg/220px-Zeng_Liansong%27s_proposal_for_the_PRC_flag.svg.png"),
            Country("us", "https://ambassadecabinetconseil.com/wp-content/uploads/2018/11/drapeau-etats-unis.jpg"),
            Country("en", "https://i.pinimg.com/originals/ea/c0/8a/eac08a5f06624b78418a77364ff28fd5.jpg"),
            Country("it", "https://images-na.ssl-images-amazon.com/images/I/2157-ZWADdL._AC_SX425_.jpg"),
            Country("de", "https://b-k.lu/wp-content/uploads/2016/05/DrAll-Allemagne-Bernard-Kauffman-1200x803.jpg"),
        )

        val adapterRecycler = CountryAdapter(countries, this)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = adapterRecycler

    }

    override fun onClick(myCountry: String) {
        (activity as? MainActivity)?.changeFragment(ArticleFragment.newInstance(myCountry))
    }
}
