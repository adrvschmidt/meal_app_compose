package br.com.schmidt.mealsapp.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import br.com.schmidt.mealsapp.model.MealsRepository
import br.com.schmidt.mealsapp.model.response.MealResponse

class MealDetailsViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val repository: MealsRepository = MealsRepository.getInstance()

    var mealState = mutableStateOf<MealResponse?>(null)

    init {
        val mealId = savedStateHandle.get<String>("meal_category_id") ?: ""
        mealState.value = repository.getMeal(mealId)
    }
}