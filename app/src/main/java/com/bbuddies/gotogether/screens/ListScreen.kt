package com.bbuddies.gotogether.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bbuddies.gotogether.R
import com.bbuddies.gotogether.entitys.EventInfo
import com.bbuddies.gotogether.entitys.User
import com.bbuddies.gotogether.ui.theme.GoTogetherTheme
import com.bbuddies.gotogether.viewModels.EventViewModel

@Composable
fun EventListScreen(eventViewModel: EventViewModel) {
    val listEventInfo: MutableList<EventInfo> by eventViewModel.listEventInfo.observeAsState(
        mutableListOf<EventInfo>()
    )
    LazyColumn(modifier = Modifier.fillMaxSize()) {

        items(listEventInfo) { value ->
            EventCard(event = (value))

        }

    }
}

@Composable
fun EventCard(event: EventInfo) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .wrapContentHeight()


    ) {
        Row(
            modifier = Modifier
                .wrapContentSize()
                .padding(start = 16.dp, top = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfilePicture(drawableId = event.owner.avatarId)
            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 8.dp)
            ) {
                Text(text = event.owner.name, style = MaterialTheme.typography.bodyLarge)
                Text(text = event.owner.age.toString(), style = MaterialTheme.typography.bodyMedium)
            }
        }
        Text(
            text = event.name,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(4.dp),
            style = MaterialTheme.typography.displaySmall,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Column(modifier = Modifier.wrapContentSize()) {
                Text(text = "Type: ${event.typeEvent}", style = MaterialTheme.typography.bodyMedium)
                Text(
                    text = "Location: ${event.location}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Column(modifier = Modifier.wrapContentSize()) {
                Text(text = "Date:${event.timeDate}", style = MaterialTheme.typography.bodyMedium)
                Text(
                    text = "Time start: ${event.timeStart}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}


@Composable
fun ProfilePicture(drawableId: Int) {
    Card(
        modifier = Modifier.size(64.dp),
        shape = CircleShape
    ) {
        AsyncImage(
            model = "https://example.com/image.jpg",
            contentDescription = "Profile Picture"
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    val viewModel = EventViewModel()
    EventListScreen(viewModel)

}