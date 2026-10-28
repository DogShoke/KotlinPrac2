
package ru.dogshoke.module2practice

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WaterTrackerTest {

    @get:Rule
    val composeTestRule =
        createAndroidComposeRule<MainActivity>()

    // Тест 1: добавление воды
    @Test
    fun addWaterTest() {
        composeTestRule
            .onNodeWithText("0 мл")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("+250 мл")
            .assertIsDisplayed()
            .performClick()

        composeTestRule
            .onNodeWithText("250 мл")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("+250 мл")
            .performClick()

        composeTestRule
            .onNodeWithText("500 мл")
            .assertIsDisplayed()
    }

    // Тест 2: завершение успешного дня
    @Test
    fun finishDayTest() {

        // Добавляем 1500 мл
        repeat(6) {
            composeTestRule
                .onNodeWithText("+250 мл")
                .performClick()
        }

        composeTestRule
            .onNodeWithText("1500 мл")
            .assertIsDisplayed()

        // Завершаем день
        composeTestRule
            .onNodeWithText("Завершить день")
            .assertIsDisplayed()
            .performClick()

        // Вода должна обнулиться
        composeTestRule
            .onNodeWithText("0 мл")
            .assertIsDisplayed()

        // Количество дней увеличилось
        composeTestRule
            .onNodeWithText("Дней подряд: 1")
            .assertIsDisplayed()
    }

    // Тест 3: серия из двух успешных дней
    @Test
    fun consecutiveDaysTest() {

        repeat(2) {
            // За каждый день выпиваем 1500 мл
            repeat(6) {
                composeTestRule
                    .onNodeWithText("+250 мл")
                    .performClick()
            }

            composeTestRule
                .onNodeWithText("Завершить день")
                .performClick()
        }

        composeTestRule
            .onNodeWithText("Дней подряд: 2")
            .assertIsDisplayed()
    }

    // Тест 4: сброс серии дней
    @Test
    fun resetStreakTest() {

        // Первый день успешный
        repeat(6) {
            composeTestRule
                .onNodeWithText("+250 мл")
                .performClick()
        }

        composeTestRule
            .onNodeWithText("Завершить день")
            .performClick()

        // Второй день: только 250 мл
        composeTestRule
            .onNodeWithText("+250 мл")
            .performClick()

        composeTestRule
            .onNodeWithText("Завершить день")
            .performClick()

        // Серия должна сброситься
        composeTestRule
            .onNodeWithText("Дней подряд: 0")
            .assertIsDisplayed()
    }
}
