package com.example.knitpack_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.knitpacktheme.theme.Off_White

@Composable
fun MulberryButton(text: String, onclick : ()->Unit){
    Button(
        onClick = { onclick },
        shape = RoundedCornerShape(3.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = Off_White,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.amiko_semibold))
            )
        )
    }
}