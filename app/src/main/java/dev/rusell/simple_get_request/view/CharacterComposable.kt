package dev.rusell.simple_get_request.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dev.rusell.simple_get_request.model.Result
import dev.rusell.simple_get_request.viewModel.CharacterViewModel


@Composable
fun CharacterComposable(viewModel: CharacterViewModel){
   val characters by viewModel.characters.observeAsState()
   
   LaunchedEffect(Unit) {
      viewModel.fetchCharacter()
   }

   Column(modifier = Modifier
      .fillMaxSize()
      .clip(RoundedCornerShape(4.dp))
      .padding(16.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
   ) {
      if (characters?.results.isNullOrEmpty()) {
         Text(text = "Loading...",
            fontSize = 24.sp)
      } else {
         Text(text = "Rick And Morty", fontSize = 24.sp)
         Spacer(modifier = Modifier.padding(10.dp))
         var chars = characters?.results as List<Result>
         chars.let { 
            LazyColumn{
               items(it) {
                  Row (modifier = Modifier
                     .border(1.dp, Color.Black)
                     .padding(10.dp)
                     .fillMaxWidth(),
                     verticalAlignment = CenterVertically,
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
                  Spacer(modifier = Modifier.padding(6.dp))
               }
            }
         }
      }
   }
}