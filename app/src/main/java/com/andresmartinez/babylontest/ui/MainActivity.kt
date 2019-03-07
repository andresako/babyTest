package com.andresmartinez.babylontest.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andresmartinez.babylontest.R
import com.andresmartinez.babylontest.components.PostsAdapter
import com.andresmartinez.babylontest.room.entities.PostsEntity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUI()
    }

    private fun setUI() {
        viewModel.loadPosts().observeForever {
            recycler.adapter = PostsAdapter(it) { post: PostsEntity -> postItemClicked(post) }
        }
        recycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycler.adapter = PostsAdapter(mutableListOf()) {}

    }

    private fun postItemClicked(post: PostsEntity) {
        Toast.makeText(this, "Clicked: ${post.title}", Toast.LENGTH_LONG).show()

        val intent = Intent(applicationContext, SecondActivity::class.java)
        intent.putExtra("POST_ID", post.id)

        startActivity(intent)

    }
}
