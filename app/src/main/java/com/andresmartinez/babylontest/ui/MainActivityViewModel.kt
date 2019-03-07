package com.andresmartinez.babylontest.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andresmartinez.babylontest.repository.PostsRepository
import com.andresmartinez.babylontest.room.entities.PostsEntity
import com.andresmartinez.babylontest.utils.Coroutines

class MainActivityViewModel(
    private val postRepo: PostsRepository
) : ViewModel() {
    private val _posts = MutableLiveData<List<PostsEntity>>()

    private val posts: LiveData<List<PostsEntity>> get() = _posts

    fun loadPosts(forceUpdate: Boolean = false): LiveData<List<PostsEntity>> {
        Coroutines.ioThenMain({
            postRepo.getAllPosts(forceUpdate)
        }) { _posts.value = it }
        return posts
    }

}