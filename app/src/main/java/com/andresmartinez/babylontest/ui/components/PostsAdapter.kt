package com.andresmartinez.babylontest.ui.components

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andresmartinez.babylontest.R
import com.andresmartinez.babylontest.room.entities.PostsEntity
import kotlinx.android.synthetic.main.post_item.view.*

class PostsAdapter(
    private val posts: List<PostsEntity>,
    val listener: (PostsEntity) -> Unit
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false))
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(posts[position], listener)
    }



}

class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    fun bindItems(post: PostsEntity, clickListener: (PostsEntity) -> Unit) {
        itemView.post_item_title.text = post.title
        itemView.post_item_desc.text = post.body
        itemView.setOnClickListener { clickListener(post)}
    }

}
