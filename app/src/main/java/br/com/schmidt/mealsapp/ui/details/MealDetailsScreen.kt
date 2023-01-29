package br.com.schmidt.mealsapp.ui.details

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import br.com.schmidt.mealsapp.model.response.MealResponse
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import kotlin.math.min

@Composable
fun MealDetailsScreen(meal: MealResponse?) {

    val scrollState = rememberLazyListState()
    val offset = min(
        1f,
        1 - (scrollState.firstVisibleItemScrollOffset / 600f + scrollState.firstVisibleItemIndex)
    )
    val size by animateDpAsState(targetValue = max(100.dp, 200.dp * offset))

    Surface(color = MaterialTheme.colors.background) {
        Column {
            Surface(elevation = 4.dp) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Card(
                        modifier = Modifier.padding(16.dp),
                        shape = CircleShape,
                        border = BorderStroke(width = 2.dp, color = Color.Green)
                    ) {
                        Image(
                            painter = rememberImagePainter(data = meal?.imageUrl ?: "", builder = {
                                transformations(CircleCropTransformation())
                            }),
                            contentDescription = null,
                            modifier = Modifier
                                .size(size)
                        )
                    }
                    Text(
                        text = meal?.name ?: "Nulo",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }
            val dummyList = (0..100).map { it.toString() }
            LazyColumn(state = scrollState) {
                items(dummyList) { item ->
                    Text(
                        text = "Teste do LazyColumn $item", modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}