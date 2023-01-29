package br.com.schmidt.mealsapp.ui.meals

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.schmidt.mealsapp.model.MealsRepository
import br.com.schmidt.mealsapp.model.response.MealResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel() {

    val mealsState = mutableStateOf(emptyList<MealResponse>())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            mealsState.value = getMeals()
        }
    }

    private suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }
}