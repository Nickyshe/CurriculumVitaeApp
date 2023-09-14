package com.example.cv_app.navigation


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cv_app.model.UserProfileViewModel
import com.example.cv_app.screen.CvView
import com.example.cv_app.screen.EditCv

@Composable

fun ComposeNavigation() {

    val navController = rememberNavController()
    val userProfile = viewModel<UserProfileViewModel>()
    NavHost(navController = navController, startDestination = "cvscreen") {
        composable("cvscreen") {
            CvView(navController = navController, viewModel = userProfile)
        }
        composable("editcv") {
            EditCv(navController = navController, viewModel = userProfile)
        }
    }
}
