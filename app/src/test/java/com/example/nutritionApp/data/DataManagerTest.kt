package com.example.nutritionApp.data

import com.example.nutritionApp.data.domain.Meal
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class DataManagerTest {
    private var dataManager: DataManager = DataManager()
    private var calculateCalories: Int? = null
    private var highProteinMeals: List<Meal>? = null
    private var mealsContainsVitamin: List<Meal>? = null
    private var mealsContainsCarb: List<Meal>? = null
    private var mealsContainsFiber: List<Meal>? = null
    private var optimalCalories: Int? = null
    private var addedMeals = mutableListOf<Meal>()

    @BeforeAll
    fun setUp() {
        addedMeals = mutableListOf(
            Meal(
                id = 0,
                calories = "500",
                name = "Pizza",
                caffeine = "10",
                fat = "10",
                protein = "10",
                saturatedFat = "10",
                servingSize = "100",
                totalFat = "10",
                water = "10 g",
                calcium = "10 g",
                fiber = "10 g",
                sugar = "10 g",
                cholesterol = "10 g",
                carb = "10 g",
                vitaminD = "10 g",
            ),
            Meal(
                id = 1,
                calories = "500",
                name = "Burger",
                caffeine = "10",
                fat = "10",
                protein = "10",
                saturatedFat = "10",
                servingSize = "100",
                totalFat = "10",
                water = "10 g",
                calcium = "10 g",
                fiber = "10 g",
                sugar = "10 g",
                cholesterol = "10 g",
                carb = "10 g",
                vitaminD = "10 g",
            ),
            Meal(
                id = 2,
                calories = "500",
                name = "Chips",
                caffeine = "10",
                fat = "10",
                protein = "10",
                saturatedFat = "10",
                servingSize = "100",
                totalFat = "10",
                water = "10 g",
                calcium = "10 g",
                fiber = "10 g",
                sugar = "10 g",
                cholesterol = "10 g",
                carb = "10 g",
                vitaminD = "10 g",
            )
        )
        optimalCalories = dataManager.optimalCalories
    }

    @org.junit.Test
    fun should_Return_CalculatedCalories_When_RunFunction() {
        // given
        println(addedMeals)
        // when
        calculateCalories = dataManager.calculateCaloriesForAddedMeals(addedMeals)

        // then
        assertEquals(
            2010,
            calculateCalories,
        )
    }

    @org.junit.Test
    fun should_Return_False_When_calculateCaloriesIsBiggerThanOptimalOnes() {
        // given
        println(addedMeals)

        // when
        calculateCalories = dataManager.calculateCaloriesForAddedMeals(addedMeals)

        // then
        assertEquals(
            false,
            calculateCalories!! > optimalCalories!!
        )
    }

    @org.junit.Test
    fun should_Return_True_When_calculateCaloriesIsSmallerThanOptimalOnes() {
        // given
        println(addedMeals)

        // when
        calculateCalories = dataManager.calculateCaloriesForAddedMeals(addedMeals)

        // then
        assertEquals(
            true,
            calculateCalories!! < optimalCalories!!
        )
    }


    @org.junit.Test
    fun should_Return_HighProteinMeals_When_Give_Them_Items_Size() {
        // given
        println(addedMeals)

        // when
        highProteinMeals = dataManager.getHighProteinMeals(addedMeals, 10)

        // then
        assertEquals(
            10,
            (highProteinMeals as MutableList<Meal>).size
        )
    }

    @org.junit.Test
    fun should_Return_MealsContainsVitamin_When_Give_Them_Items_Size() {
        // given
        println(addedMeals)

        // when
        mealsContainsVitamin =
            dataManager.getTopMealsContainsVitamin(addedMeals, 10)

        // then
        assertEquals(
            10,
            (mealsContainsVitamin as MutableList<Meal>).size
        )
    }


    @org.junit.Test
    fun should_Return_MealsContainsCarb_When_Give_Them_Items_Size() {
        // given
        println(addedMeals)

        // when
        mealsContainsCarb =
            dataManager.getTopMealsContainsVitamin(addedMeals, 10)

        // then
        assertEquals(
            10,
            (mealsContainsCarb as MutableList<Meal>).size
        )
    }


    @org.junit.Test
    fun should_Return_MealsContainsFiber_When_Give_Them_Items_Size() {
        // given
        println(addedMeals)

        // when
        mealsContainsFiber =
            dataManager.getTopMealsContainsVitamin(addedMeals, 10)

        // then
        assertEquals(
            10,
            (mealsContainsFiber as MutableList<Meal>).size
        )
    }


}