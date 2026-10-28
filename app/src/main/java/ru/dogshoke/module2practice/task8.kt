
package ru.dogshoke.module2practice

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WaterTracker() {

    // Количество выпитой воды
    var waterCount by remember {
        mutableIntStateOf(0)
    }

    // Количество успешных дней подряд
    var streakDays by remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Трекер воды",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3F6295)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "$waterCount мл",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Добавляем 250 мл
        Button(
            onClick = {
                waterCount += 250
            }
        ) {
            Text(
                text = "+250 мл",
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Завершение дня
        Button(
            onClick = {
                if (waterCount >= 1500) {
                    streakDays++
                } else {
                    streakDays = 0
                }

                waterCount = 0
            }
        ) {
            Text(
                text = "Завершить день",
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Дней подряд: $streakDays",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Цель: 1500 мл в день",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Preview(
    name = "Задание 8",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun Task8Preview() {
    WaterTracker()
}
