package com.example.newsletter.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsletter.MainActivity
import com.example.newsletter.R
import com.example.newsletter.data.Article
import com.example.newsletter.fragments.ArticleDetailsFragment
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext


class ArticleAdapter(private val dataset: List<Article>) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
    inner class ViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(item: Article) {
            val txtTitle = root.findViewById<TextView>(R.id.title)
            val img = root.findViewById<AppCompatImageView>(R.id.image)
            val txauthor = root.findViewById<TextView>(R.id.author)
            val txcontent = root.findViewById<TextView>(R.id.content)
            val datepublishedAt =  root.findViewById<TextView>(R.id.publishedAt)

            txtTitle.text = item.title
            Glide.with(root).load(item.urlToImage).into(img)
            txauthor.text = item.author
            datepublishedAt.text = item.publishedAt.toString()
            txcontent.text = item.content

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_articles, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int = dataset.size
}

