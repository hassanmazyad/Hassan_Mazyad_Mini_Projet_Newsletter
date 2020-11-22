package com.example.newsletter.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsletter.R
import com.example.newsletter.data.Article
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class ArticleDetailsAdapter(private val article: Article  , private val callback: CallBack) :
    RecyclerView.Adapter<ArticleDetailsAdapter.ViewHolder>() {
    inner class ViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(item: Article) {
            val txtTitle = root.findViewById<TextView>(R.id.title)
            val img = root.findViewById<AppCompatImageView>(R.id.image)
            val txauthor = root.findViewById<TextView>(R.id.author)
            val txcontent = root.findViewById<TextView>(R.id.content)
            val datepublishedAt =  root.findViewById<TextView>(R.id.publishedAt)
            val txdescription = root.findViewById<TextView>(R.id.description)
            val txurl = root.findViewById<TextView>(R.id.url)

            txtTitle.text = item.title
            Glide.with(root).load(item.urlToImage).into(img)
            txauthor.text = item.author
            txcontent.text = item.content
            datepublishedAt.text = item.publishedAt.toString()
            txdescription.text = item.description
            txurl.text = item.url

            root.setOnClickListener {
                callback.onClick(item.title)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_articledetails, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ArticleDetailsAdapter.ViewHolder, position: Int) {
        holder.bind(article)
    }

    override fun getItemCount(): Int = 1
}