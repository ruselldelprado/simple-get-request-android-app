package dev.rusell.simple_get_request.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.rusell.simple_get_request.model.Result

@Composable
fun CharacterCardComposable(it: Result) {
    Row (modifier = Modifier
        .border(1.dp, Color.Black)
        .padding(10.dp)
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ){
        AsyncImage(
            model = it.image,
            contentDescription = "${it.name} image",
            modifier = Modifier.size(width = 100.dp, height = 100.dp)
        )
        Spacer(modifier = Modifier.padding(40.dp))
        Column {
            Text(text = it.name)
            Text(text = it.status)
            Text(text = it.gender)
        }
    }
}