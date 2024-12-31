package com.akhijix.protaskinate.ui.deleteallcompleted

import androidx.lifecycle.ViewModel
import com.akhijix.protaskinate.data.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeleteAllCompletedViewModel @Inject constructor(
    private val taskDao : TaskDao,
) : ViewModel() {

    fun onConfirmClicked() = MainScope().launch {
        taskDao.deleteCompletedTasks()
    }
}