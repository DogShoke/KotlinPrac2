
package ru.dogshoke.module2practice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Верхняя панель, как в методичке
@Composable
fun Task7Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color(0xFF6200EE))
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = "FirstComposeProject",
            color = Color.White,
            fontSize = 20.sp
        )
    }
}

// Данные одного человека
@Composable
fun Task7Contact(
    name: String,
    patronymic: String,
    surname: String,
    phone: String,
    address: String,
    modifier: Modifier = Modifier,
    alignment: TextAlign = TextAlign.Start
) {
    Column(modifier = modifier) {
        listOf(
            "Имя: $name",
            "Отчество: $patronymic",
            "Фамилия: $surname",
            "Мобильный телефон: $phone",
            "Адрес: $address"
        ).forEach { line ->
            Text(
                text = line,
                fontSize = 14.sp,
                textAlign = alignment,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

// Вариант 1: данные в Column
@Composable
fun Task7First() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Task7Header()

        Task7Contact(
            name = "Евгений",
            patronymic = "Андреевич",
            surname = "Лукашин",
            phone = "+7 495 495 95 95",
            address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12"
        )
    }
}

// Вариант 2: три карточки в Column
@Composable
fun Task7Second() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Task7Header()

        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Task7Contact(
                name = "Евгений",
                patronymic = "Андреевич",
                surname = "Лукашин",
                phone = "+7 495 495 95 95",
                address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12",
                alignment = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp)
            )

            Task7Contact(
                name = "Василий",
                patronymic = "Егорович",
                surname = "Кузякин",
                phone = "---",
                address = "Ивановская область, дер. Крутово, д. 4",
                alignment = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp)
            )

            Task7Contact(
                name = "Людмила",
                patronymic = "Петровна",
                surname = "Калугина",
                phone = "+7 495 788 78 78",
                address = "Москва, Большая Никитская, д. 43, кв. 290",
                alignment = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp)
            )
        }
    }
}

// Вариант 3: Row с картинкой справа
@Composable
fun Task7Third() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Task7Header()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.LightGray)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Task7Contact(
                name = "Евгений",
                patronymic = "Андреевич",
                surname = "Лукашин",
                phone = "+7 495 495 95 95",
                address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12",
                alignment = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )

            Image(
                painter = painterResource(R.drawable.circle),
                contentDescription = "Изображение контакта",
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

// Три предпросмотра
@Preview(
    name = "Задание 7 - Column",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun Task7Preview1() {
    Task7First()
}

@Preview(
    name = "Задание 7 - Список",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun Task7Preview2() {
    Task7Second()
}

@Preview(
    name = "Задание 7 - Row",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun Task7Preview3() {
    Task7Third()
}
