package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                lemonDrinkApp()
            }
        }
    }
}

@Preview
@Composable
fun lemonDrinkApp(){
    
    makeDrink(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}

@Composable
fun makeDrink(modifier: Modifier = Modifier){

    Column(
        modifier = modifier
        , horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = stringResource(id = R.string.tree_img),
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.lemon_tree),
            contentDescription = "Lemon Tree",
//            modifier = Modifier.border(1.dp, Color.Blue)
        )
    }
}