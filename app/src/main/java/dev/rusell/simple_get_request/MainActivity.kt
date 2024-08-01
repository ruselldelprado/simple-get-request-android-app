package dev.rusell.simple_get_request

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.rusell.simple_get_request.view.CharacterComposable
import dev.rusell.simple_get_request.viewModel.CharacterViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: CharacterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier
                    .background(Color.Blue)

            ) {
                CharacterComposable(viewModel)
            }
        }
    }
}

