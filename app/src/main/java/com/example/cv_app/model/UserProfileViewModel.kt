package com.example.cv_app.model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserProfileViewModel : ViewModel() {
    private var _stateFlow = MutableStateFlow(
        CvDetails(
            "Etugbo Judith Ogheneujiro ",
            "Ju_dy",
            "Nickyshe",
            "I'm a Software Developer Technical Writer"
        )
    )

    val stateFlow: StateFlow<CvDetails> = _stateFlow
    fun updateCv(details: CvDetails) {
        _stateFlow.value = details


    }

}