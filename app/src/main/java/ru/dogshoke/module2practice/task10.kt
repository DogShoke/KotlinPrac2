
package ru.dogshoke.module2practice

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

// Модель товара
data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

// Модель корзины
data class Cart(
    val products: List<Product>
)

// Основной экран корзины
@Composable
fun ShoppingCartScreen() {

    val context = LocalContext.current

    // Состояние корзины
    var cart by remember {
        mutableStateOf(
            Cart(
                products = listOf(
                    Product(0, "Товар #1", 100),
                    Product(1, "Товар #2", 150),
                    Product(2, "Товар #3", 56)
                )
            )
        )
    }

    // Сумма всегда вычисляется из текущего списка
    val totalSum = cart.products.sumOf { it.price }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Text(
            text = "Корзина товаров",
            fontSize = 26.sp
        )

        // Отображение всех товаров
        cart.products.forEach { product ->
            Text(
                text = "${product.name} - ${product.price} рублей",
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Общая стоимость
        Text(
            text = "Товаров на сумму: $totalSum рублей",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Кнопка добавления товара
        AddProductSection(
            onAdd = {

                val nextId =
                    (cart.products.maxOfOrNull { it.id } ?: -1) + 1

                val newProduct = Product(
                    id = nextId,
                    name = "Товар #${nextId + 1}",
                    price = Random.nextInt(0, 100)
                )

                // Создаём новый список
                val updatedProducts =
                    cart.products + newProduct

                // Обновляем состояние корзины
                cart = cart.copy(
                    products = updatedProducts
                )

                // Проверяем сумму после добавления
                val newTotal =
                    updatedProducts.sumOf { it.price }

                if (newTotal > 500) {
                    Toast.makeText(
                        context,
                        "Доставка бесплатная!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        )

        // Кнопка удаления товара
        RemoveProductSection(
            hasProducts = cart.products.isNotEmpty(),
            onRemove = {
                cart = cart.copy(
                    products = cart.products.dropLast(1)
                )
            }
        )
    }
}

// Добавление товара
@Composable
fun AddProductSection(
    onAdd: () -> Unit
) {
    Button(
        onClick = onAdd
    ) {
        Text(text = "Добавить товар")
    }
}

// Удаление товара
@Composable
fun RemoveProductSection(
    hasProducts: Boolean,
    onRemove: () -> Unit
) {
    if (hasProducts) {
        Button(
            onClick = onRemove
        ) {
            Text(text = "Удалить товар")
        }
    }
}

// Предпросмотр
@Preview(
    name = "Задание 10",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun Task10Preview() {
    ShoppingCartScreen()
}
