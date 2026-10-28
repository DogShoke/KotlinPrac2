package ru.dogshoke.module2practice
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*setContent {
            WaterTracker()
        }*/
        setContent {
            ShoppingCartScreen()
        }
    }
}

@Composable
fun Hello(name: String?) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (name == null) {
                "Имя не задано"
            } else {
                "Привет, $name!"
            }
        )
    }
}


@Preview(
    name = "portrait",
    device = "spec:width=411dp,height=891dp,orientation=portrait,dpi=420",
    showSystemUi = true
)
@Preview(
    name = "landscape",
    device = "spec:width=411dp,height=891dp,orientation=landscape,dpi=420",
    showSystemUi = true
)
@Preview(
    name = "round",
    device = "spec:width=200dp,height=200dp,dpi=320,isRound=true",
    showSystemUi = true,
    showBackground = true,
    backgroundColor = 0xFFFFFF00
)
@Composable
fun HelloPreview() {
    Hello(name = "Андрей")
}

