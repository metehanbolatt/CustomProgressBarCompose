package com.metehanbolat.customprogressbarcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.metehanbolat.customprogressbarcompose.ui.theme.CustomProgressBarComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomProgressBarComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CustomProgressBar(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .height(20.dp),
                            width = 300.dp,
                            backgroundColor = Color.Gray,
                            foregroundColor = Brush.horizontalGradient(listOf(Color(0xF0288D21), Color(0xF055CA4D))),
                            percent = 21,
                            isShownText = true
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CustomProgressBar(
    modifier: Modifier,
    width: Dp,
    backgroundColor: Color,
    foregroundColor: Brush,
    percent: Int,
    isShownText: Boolean
) {
    Box(
        modifier = modifier
            .background(backgroundColor)
            .width(width)
    ) {
        Box(
            modifier = modifier
                .background(foregroundColor)
                .width(width * percent / 100)
        )
        if (isShownText) {
            Text(
                text = "$percent %",
                modifier = Modifier.align(Alignment.Center),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}