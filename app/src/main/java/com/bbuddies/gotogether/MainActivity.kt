package com.bbuddies.gotogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bbuddies.gotogether.entitys.EventInfo
import com.bbuddies.gotogether.screens.EventCard
import com.bbuddies.gotogether.screens.EventListScreen
import com.bbuddies.gotogether.ui.theme.GoTogetherTheme
import com.bbuddies.gotogether.viewModels.EventViewModel

class MainActivity : ComponentActivity() {
    private val eventListViewModel = EventViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                EventListScreen(eventListViewModel)
            }
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun ListScreenPreview() {
        EventListScreen(eventListViewModel )

    }

}



