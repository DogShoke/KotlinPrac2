
package ru.dogshoke.module2practice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(name = "Вариант 1", showBackground = true)
@Composable
fun Task3Preview1() {
    Text(
        text = stringResource(R.string.compose_description),
        color = Color.Green,
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(name = "Вариант 2", showBackground = true)
@Composable
fun Task3Preview2() {
    Text(
        text = stringResource(R.string.compose_description),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(name = "Вариант 3", showBackground = true)
@Composable
fun Task3Preview3() {
    Text(
        text = stringResource(R.string.compose_description),
        color = Color.Black,
        fontSize = 24.sp,
        textDecoration = TextDecoration.Underline,
        style = TextStyle(
            textIndent = TextIndent(firstLine = 48.sp)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green)
    )
}
