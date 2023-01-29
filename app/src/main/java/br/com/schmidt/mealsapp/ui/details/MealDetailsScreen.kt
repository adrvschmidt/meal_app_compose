package br.com.schmidt.mealsapp.ui.details

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.schmidt.mealsapp.model.response.MealResponse
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation

@Composable
fun MealDetailsScreen(meal: MealResponse?) {
    var profilePictureState by remember {
        mutableStateOf(ProfilePictureState.Normal)
    }
    val transition = updateTransition(targetState = profilePictureState, label = "")
    val imageSizeDp by transition.animateDp(targetValueByState = { it.size }, label = "")
    val borderWidth by transition.animateDp(targetValueByState = { it.borderWidth }, label = "")
    val color by transition.animateColor(targetValueByState = { it.color }, label = "")

    Box {
        Column {
            Row {
                Card(
                    modifier = Modifier.padding(16.dp),
                    shape = CircleShape,
                    border = BorderStroke(width = borderWidth, color = color)
                ) {
                    Image(
                        painter = rememberImagePainter(data = meal?.imageUrl ?: "", builder = {
                            transformations(CircleCropTransformation())
                        }),
                        contentDescription = null,
                        modifier = Modifier
                            .size(imageSizeDp)
                            .padding(8.dp)
                    )
                }
                Text(
                    text = meal?.name ?: "Nulo",
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterVertically)
                )
            }
            Button(onClick = {
                profilePictureState =
                    if (profilePictureState == ProfilePictureState.Normal) ProfilePictureState.Expanded else ProfilePictureState.Normal
            }, modifier = Modifier.padding(16.dp)) {
                Text(text = "Change state of meal profile picture")

            }
        }
    }
}

enum class ProfilePictureState(val color: Color, val size: Dp, val borderWidth: Dp) {
    Normal(Color.Magenta, 120.dp, 8.dp),
    Expanded(Color.Green, 200.dp, 24.dp)
}