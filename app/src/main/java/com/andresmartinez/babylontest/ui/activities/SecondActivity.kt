package com.andresmartinez.babylontest.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.andresmartinez.babylontest.R
import com.andresmartinez.babylontest.ui.viewmodels.SecondActivityViewModel
import kotlinx.android.synthetic.main.activity_second.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondActivity : AppCompatActivity() {

    val model: SecondActivityViewModel by viewModel()
    var postId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        postId = intent.getIntExtra("POST_ID", 0)

        setObservers()
        getData()
    }

    private fun setObservers() {
        model.post.observeForever {
            second_title.text = it.title
            second_desc.text = it.body
        }

        model.user.observeForever {
            second_author.text = getString(R.string.author, it.name)
        }
        model.commentsCount.observeForever {
            second_count.text = getString(R.string.comments, it.toString())
        }
    }

    private fun getData() {
        model.getPostInfo(postId)
    }
}
