package com.oysoft.studyapp.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.serpent.ui.theme.AppTheme
import com.oysoft.studyapp.screens.FlashCardsScreen
import com.oysoft.studyapp.viewModels.FlashCardsViewModel

class FlashCardsFragment : Fragment() {

    private val flashCardsViewModel: FlashCardsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext())
            .apply {
                setContent {
                    AppTheme(darkTheme = true) {
                        Scaffold { paddingScaffold ->
                            FlashCardsScreen(
                                modifier = Modifier.padding(paddingScaffold),
                                flashCardsViewModel = flashCardsViewModel
                            )
                        }
                    }
                }
            }
    }
}