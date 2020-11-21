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
import com.example.newsletter.adapters.EditorAdapter
import com.example.newsletter.data.Editor

class EditorsFragment : Fragment() , CallBack {
    lateinit var recyclerView: RecyclerView

    private lateinit var name: String

    companion object {
        fun newInstance(name: String): EditorsFragment {
            return EditorsFragment().apply {
                this.name = name
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_editors, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view)

        val editors = listOf<Editor>(
            Editor("ABC News","https://play-lh.googleusercontent.com/WQoEKDSuvxPGChUQoAY_vdd26b4yt9mZXynWplNUecUVOX2GwxV3gY0jy0uE941huvo"),
            Editor("Bild","https://yt3.ggpht.com/a/AATXAJwz7ia5pGAf1MioWMeWuO-2IFSE7Xx2piV6DEOK=s900-c-k-c0xffffffff-no-rj-mo"),
            Editor("Blasting News (BR)","https://upload.wikimedia.org/wikipedia/commons/6/66/LogoBN-1.png"),
            Editor("Bleacher Report","https://awfulannouncing.com/wp-content/uploads/sites/94/2020/09/BR_logo19.png"),
            Editor("Bloomberg","https://mercomcapital.com/wp-content/uploads/2016/02/Bloomberg-Logo.jpg"),
            Editor("Business Insider","https://appebike.com/fr/wp-content/uploads/2018/01/Logo-Business-Insider.png"),

        )

        val editorRecycler = EditorAdapter(editors, this)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = editorRecycler
    }

    override fun onClick(myEditors: String) {
        (activity as? MainActivity)?.changeFragment(ArticleFragment.newInstance(myEditors))
    }

}