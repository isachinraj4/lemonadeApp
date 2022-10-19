package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.colorspace.ColorSpace
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.graphics.colorspace.Rgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {

                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {
    var imageClickCount by remember { mutableStateOf(1) }
    var sqzClicCount by remember {
        mutableStateOf(0)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        when(imageClickCount) {
            1 -> {
                LemonTextAndImage(
                    textLabelResourceId = R.string.lemon_img,
                    drawableResourceId = R.drawable.lemon_tree,
                    contentDescriptionResourceId = R.string.lemon_tree,
                    onImageClick = {
                        imageClickCount = 2
                        sqzClicCount = (2..4).random()
                    })
            }
            2 -> {
                LemonTextAndImage(
                    textLabelResourceId = R.string.lemon_img,
                    drawableResourceId = R.drawable.lemon_squeeze,
                    contentDescriptionResourceId = R.string.lemon,
                    onImageClick = {
                        sqzClicCount--
                        if(sqzClicCount == 0){
                            imageClickCount = 3
                        }
                    })
            }
            3 -> {
                LemonTextAndImage(
                    textLabelResourceId = R.string.drink_glass_img,
                    drawableResourceId = R.drawable.lemon_drink,
                    contentDescriptionResourceId = R.string.drink_glass,
                    onImageClick = {
                        imageClickCount = 4
                    })
            }
            4 -> {
                LemonTextAndImage(
                    textLabelResourceId = R.string.empty_glass_img,
                    drawableResourceId = R.drawable.lemon_restart,
                    contentDescriptionResourceId = R.string.empty_glass,
                    onImageClick = {
                        imageClickCount = 1
                    })
            }
        }
    }

}

@Composable
fun LemonTextAndImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(text = stringResource(id = textLabelResourceId),
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        Image(painter = painterResource(id = drawableResourceId), contentDescription = stringResource(
            id = contentDescriptionResourceId
        ),
        modifier = Modifier
            .wrapContentSize()
            .clickable(
                onClick = onImageClick
            )
            .border(
                BorderStroke(2.dp, Color(105, 205, 216)),
                shape = RoundedCornerShape(40.dp)
            )
            .padding(16.dp)
        )
    }
}

@Preview
@Composable
fun LemonPreview() {
    LemonadeTheme() {
        LemonApp()
    }
}