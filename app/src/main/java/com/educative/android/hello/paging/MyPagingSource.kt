package com.educative.android.hello.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.educative.android.hello.models.User
import com.educative.android.hello.models.UserResponse
import kotlin.random.Random

class MyPagingSource() : PagingSource<Int, User>() {
    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, User> {
        Log.d("MyPagingSource", "Load results called")
        return try {
            val userResponse = getUsers(params.key ?: 1)
            LoadResult.Page(
                data = userResponse.users,
                prevKey = null,
                nextKey = userResponse.nextPageNum
            )
        } catch (e: Exception) {
            Log.e("MyPagingSource", "Error occurred", e)
            LoadResult.Error(e)
        }
    }

    private fun getUsers(pageNum: Int): UserResponse {
        val random = Random(42)
        val users = mutableListOf<User>();
        for (i in 1..10) {
            val randId = random.nextInt()
            users
                .add(
                    User(
                        "user_${pageNum}_${randId}",
                        "user_email_${pageNum}_${randId}@test.com"
                    )
                )
        }
        Log.d("MyPagingSource", "Results ${users.size}")
        return UserResponse(users, pageNum + 1)
    }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}