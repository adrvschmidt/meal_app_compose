package br.com.schmidt.mealsapp.model

import br.com.schmidt.mealsapp.model.api.MealsWebService
import br.com.schmidt.mealsapp.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    suspend fun getMeals(): MealsCategoriesResponse {
        return webService.getMeals()
    }
}