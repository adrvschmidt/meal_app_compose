package br.com.schmidt.mealsapp.ui.meals

import androidx.lifecycle.ViewModel
import br.com.schmidt.mealsapp.model.MealsRepository
import br.com.schmidt.mealsapp.model.response.MealResponse
import br.com.schmidt.mealsapp.model.response.MealsCategoriesResponse

class MealCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) : ViewModel() {

    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        repository.getMeals { mealResponse ->
            successCallback(mealResponse)
        }
    }
}