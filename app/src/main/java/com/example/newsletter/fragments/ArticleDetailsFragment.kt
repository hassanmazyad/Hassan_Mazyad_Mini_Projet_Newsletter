package com.example.newsletter.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsletter.R



/**
 * A simple [Fragment] subclass.
 * Use the [ArticleDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArticleDetailsFragment : Fragment() {
    private lateinit var article: String

    companion object {
        fun newInstance(articleName: String): ArticleDetailsFragment {
            return ArticleDetailsFragment().apply {
                this.article = articleName
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_articledetails, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}