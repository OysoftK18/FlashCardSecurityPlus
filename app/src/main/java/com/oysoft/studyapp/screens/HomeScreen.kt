package com.oysoft.studyapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.serpent.ui.theme.CustomTypo
import com.oysoft.studyapp.R
import com.oysoft.studyapp.navigation.Screen

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController) {
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
                onClick = { navController.navigate(Screen.FlashCards.route) }) {
                Text(text = stringResource(R.string.start))
            }
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp), onClick = { /*TODO*/ }) {
                Text(text = stringResource(R.string.sync_questions))
            }
        }
        Text(text = stringResource(R.string.created_by_oysoft))
    }
}