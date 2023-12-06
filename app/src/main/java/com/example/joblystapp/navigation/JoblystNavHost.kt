package com.example.joblystapp.navigation

import android.app.Activity.RESULT_OK
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.joblystapp.auth.DetailScreen
import com.example.joblystapp.auth.DetailScreen2
import com.example.joblystapp.auth.FilterScreen
import com.example.joblystapp.auth.GoogleAuthUIClient
import com.example.joblystapp.auth.HomeScreen
import com.example.joblystapp.auth.NotifScreen
import com.example.joblystapp.auth.ProfileScreen
import com.example.joblystapp.auth.ProfileScreen2
import com.example.joblystapp.auth.SavedScreen
import com.example.joblystapp.auth.SignInScreen
import com.example.joblystapp.auth.SignUpScreen
import com.example.joblystapp.auth.TagScreen
import com.example.joblystapp.auth.WelcomeScreen
import com.example.joblystapp.auth.WelcomeScreen2
import com.example.joblystapp.model.SignInViewModel
import com.example.joblystapp.model.SignUpViewModel
import kotlinx.coroutines.launch

@Composable
fun JoblystNavHost(activity: ComponentActivity, googleAuthUIClient: GoogleAuthUIClient) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome1") {
        composable("welcome1") {
            WelcomeScreen(navController = navController)
        }
        composable("welcome2") {
            WelcomeScreen2(navController = navController)
        }
        composable("menu") {
            HomeScreen(onBackPressed = { navController.popBackStack() }, navController)
        }
        composable("filter") {
            FilterScreen (onBackPressed = { navController.popBackStack() })
        }
        composable("notif") {
            NotifScreen(onBackPressed = { navController.popBackStack() }, navController)
        }
        composable("saved") {
            SavedScreen(onBackPressed = {})
        }
        composable("tag") {
            TagScreen(navController = navController)
        }
        composable("details1") {
            DetailScreen(onBackPressed = { navController.popBackStack() }, navController)
        }
        composable("details2") {
            DetailScreen2(onBackPressed = { navController.popBackStack() }, navController)
        }
        composable("sign_in") {
            val viewModel = viewModel<SignInViewModel>()
            val signinstate by viewModel.signinstate.collectAsStateWithLifecycle()

            LaunchedEffect(key1 = Unit) {
                if (googleAuthUIClient.getSignedInUser() != null) {
                    navController.navigate("filter")
                }
            }

            val launcher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.StartIntentSenderForResult(),
                onResult = { result ->
                    if (result.resultCode == RESULT_OK) {
                        navController.navigate("filter")
                        activity.lifecycleScope.launch {
                            val signInResult = googleAuthUIClient.SignInWithIntent(
                                intent = result.data ?: return@launch
                            )
                            viewModel.onSignInResult(signInResult)
                        }
                    }
                }
            )

            SignInScreen(
                state = signinstate,
                onSignInClick = { email, password ->
                    viewModel.signInWithEmailAndPassword(email, password)
                },
                onGoogleSignInClick = {
                    activity.lifecycleScope.launch {
                        val signInIntentSender = googleAuthUIClient.signIn()
                        launcher.launch(
                            IntentSenderRequest.Builder(
                                signInIntentSender ?: return@launch
                            ).build()
                        )
                    }
                },
                navController = navController
            )
        }
        composable("sign_up") {
            val viewModel = viewModel<SignUpViewModel>()
            val signupstate by viewModel.signupState.collectAsStateWithLifecycle()

            SignUpScreen(
                state = signupstate,
                onSignUpClick = { username, email, password ->
                    viewModel.signUpWithEmailAndPassword(username, email, password)
                    navController.navigate("sign_in")
                },
                navController = navController
            )
        }
        composable("profile1") {
            ProfileScreen(navController = navController)
        }
        composable("profile2") {
            ProfileScreen2(navController = navController)
        }
    }
}
