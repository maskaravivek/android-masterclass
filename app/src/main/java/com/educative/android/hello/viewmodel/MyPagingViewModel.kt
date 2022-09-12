package com.educative.android.hello.viewmodel

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.educative.android.hello.paging.MyPagingSource

class MyPagingViewModel : ViewModel(), DefaultLifecycleObserver {
    val flow =
        Pager(PagingConfig(pageSize = 10))
        { MyPagingSource() }
            .flow.cachedIn(viewModelScope)
}