package com.oysoft.studyapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.serpent.ui.theme.CustomTypo
import com.oysoft.studyapp.R
import com.oysoft.studyapp.navigation.Screen
import com.oysoft.studyapp.viewModels.HomeScreenViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    homeScreenViewModel: HomeScreenViewModel
) {
    val flashCards by homeScreenViewModel.flashCards.collectAsState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 32.dp, top = 32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.weight(0.6f), verticalArrangement = Arrangement.Center) {
            Text(
                text = stringResource(R.string.flashcard_for_comptia_security),
                style = CustomTypo.headlineLarge
            )
        }
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
                enabled = flashCards.isNotEmpty(),
                onClick = {
                    navController.navigate(Screen.FlashCards.route)
                }) {
                Text(text = stringResource(R.string.start))
            }
        }
        Text(text = stringResource(R.string.created_by_oysoft))
    }
}