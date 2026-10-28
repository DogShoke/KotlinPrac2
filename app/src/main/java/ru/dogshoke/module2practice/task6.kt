
package ru.dogshoke.module2practice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Задание 6. Первый вариант
// Черный контейнер 240x120 dp
// Оранжевый круг в правом верхнем углу

@Composable
fun Task6First() {
    Box(
        modifier = Modifier
            .requiredSize(
                width = 240.dp,
                height = 120.dp
            )
            .background(Color.Black),
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.circle
            ),
            contentDescription = "Оранжевый круг",
            modifier = Modifier.size(48.dp)
        )
    }
}

// Задание 6. Второй вариант
// Синий контейнер 240x120 dp
// Фиолетовый овал по центру

@Composable
fun Task6Second() {
    Box(
        modifier = Modifier
            .requiredSize(
                width = 240.dp,
                height = 120.dp
            )
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.circle
            ),
            contentDescription = "Фиолетовый круг",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(
                Color(0xFF800080)
            )
        )
    }
}

// Предпросмотр первого варианта

@Preview(
    name = "Задание 6 - Вариант 1",
    showBackground = true,
    showSystemUi = true,
    widthDp = 360,
    heightDp = 640
)
@Composable
fun Task6Preview1() {
    Task6First()
}

// Предпросмотр второго варианта

@Preview(
    name = "Задание 6 - Вариант 2",
    showBackground = true,
    showSystemUi = true,
    widthDp = 360,
    heightDp = 640
)
@Composable
fun Task6Preview2() {
    Task6Second()
}
