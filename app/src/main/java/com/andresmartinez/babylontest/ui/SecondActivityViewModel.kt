package com.andresmartinez.babylontest.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andresmartinez.babylontest.repository.CommentsRepository
import com.andresmartinez.babylontest.repository.PostsRepository
import com.andresmartinez.babylontest.repository.UsersRepository
import com.andresmartinez.babylontest.room.entities.PostsEntity
import com.andresmartinez.babylontest.room.entities.UsersEntity
import com.andresmartinez.babylontest.utils.Coroutines
import kotlinx.coroutines.runBlocking

class SecondActivityViewModel(
    private var commentsRepository: CommentsRepository,
    private var usersRepository: UsersRepository,
    private var postsRepository: PostsRepository
) : ViewModel() {

    private val _post = MutableLiveData<PostsEntity>()
    private val _commentCount = MutableLiveData<Int>()
    private val _user = MutableLiveData<UsersEntity>()

    val post: LiveData<PostsEntity> get() = _post
    val commentsCount: LiveData<Int> get() = _commentCount
    val user: LiveData<UsersEntity> get() = _user


    private fun getPostById(postId: Int) {
        Coroutines.ioThenMain({
            postsRepository.getPostById(postId)
        }) {
            _post.postValue(it)
            getUserById(it?.userId ?: 0)
        }
    }

    private fun getUserById(userId: Int) {
        Coroutines.ioThenMain({
            usersRepository.getUserById(userId)
        }) { _user.postValue(it) }
    }

    private fun getCommentsCountByPostId(postId: Int) {
        Coroutines.ioThenMain({
            commentsRepository.getCount(postId)
        }) { _commentCount.postValue(it) }
    }

    fun getPostInfo(postId: Int) {

        getPostById(postId)
        getCommentsCountByPostId(postId)
    }
}