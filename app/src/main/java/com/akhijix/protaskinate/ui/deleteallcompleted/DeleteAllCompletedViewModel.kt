package com.akhijix.protaskinate.ui.deleteallcompleted

import androidx.lifecycle.ViewModel
import com.akhijix.protaskinate.data.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeleteAllCompletedViewModel @Inject constructor(
    private val taskDao : TaskDao,
    private val applicationScope: CoroutineScope
) : ViewModel() {

    fun onConfirmClicked() = applicationScope.launch {
        taskDao.deleteCompletedTasks()
    }
}