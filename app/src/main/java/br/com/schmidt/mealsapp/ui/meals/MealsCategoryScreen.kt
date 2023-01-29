package br.com.schmidt.mealsapp.ui.meals

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.schmidt.mealsapp.model.response.MealResponse
import br.com.schmidt.mealsapp.ui.theme.MealsAppTheme
import coil.compose.rememberAsyncImagePainter

@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealCategoriesViewModel = viewModel()

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(viewModel.mealsState.value) {
            MealCategory(it)
        }
    }
}

@Composable
fun MealCategory(meal: MealResponse) {
    val painter = rememberAsyncImagePainter(meal.imageUrl)
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 10.dp, end = 10.dp)
    ) {
        Row {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .size(88.dp)
                    .padding(4.dp)
            )
            Column(modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(10.dp)) {
                Text(text = meal.name,
                    style = MaterialTheme.typography.h6 )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealsAppTheme {
        MealsCategoriesScreen()
    }
}