package com.example.knitpack_components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.knitpacktheme.theme.Mulberry_Light
import com.example.knitpacktheme.theme.Mulberry_Primary
import com.example.knitpacktheme.theme.Off_White


object KnitFormUI {


    @Composable
    fun KnittingTextField(title: String, hint: String, value: String?, onChange: (String) -> Unit) {

        val source = remember {
            MutableInteractionSource()
        }

        val focusRequester = remember { FocusRequester() }

        val borderColor = remember {
            mutableStateOf(Color.LightGray)
        }
        val titleColor = remember {
            mutableStateOf(Color.Black)
        }
        if (source.collectIsFocusedAsState().value) {
            borderColor.value = Mulberry_Primary
            titleColor.value = Mulberry_Primary
        } else {
            borderColor.value = Color.LightGray
            titleColor.value = Color.Black
        }

        Column {
            Text(
                text = title,
                fontFamily = FontFamily(Font(R.font.amiko_bold)),
                fontSize = 20.sp,
                color = titleColor.value
            )
            TextField(
                value = value ?: "", onValueChange = onChange,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color(131, 52, 71),
                    unfocusedIndicatorColor = Color.LightGray
                ),
                interactionSource = source,
                leadingIcon = {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "",
                        tint = borderColor.value
                    )
                },
                placeholder = {
                    Column(
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Text(
                            text = hint,
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.amiko_regular)),
                                fontSize = 14.sp
                            )
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }


    @Composable
    fun KnittingDialogLauncher(title: String, value: String?, launchCallback: () -> Unit) {

        var borderColor = remember {
            mutableStateOf(Color.LightGray)
        }

        val leftComposableModifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.End)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { launchCallback() },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    fontFamily = FontFamily(Font(R.font.amiko_bold)),
                    fontSize = 20.sp,
                    color = borderColor.value
                )

                value?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.amiko_regular)),
                            fontSize = 14.sp,
                            color = Color(131, 52, 71)
                        ),
                        modifier = leftComposableModifier
                    )
                } ?: Icon(
                    Icons.Filled.Add,
                    contentDescription = "",
                    tint = Color(131, 52, 71),
                    modifier = leftComposableModifier
                )
            }


            Spacer(modifier = Modifier.height(10.dp))
            Divider(color = borderColor.value)
        }
    }

    @Composable
    fun PictureField() {
        Column {
            Text(
                text = "Pictures",
                fontFamily = FontFamily(Font(R.font.amiko_bold)),
                fontSize = 20.sp,
                color = Color.Black
            )
            KnitPictures()
        }
    }


    @Composable
    fun KnitPictures() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                modifier = Modifier
                    .background(Off_White, RoundedCornerShape(0.dp))
                    .fillMaxHeight()
                    .weight(1f)
                    .width(100.dp)
            ) {
                ImageHolder(
                    upperMod = Modifier
                        .weight(1f)
                        .fillMaxSize()
                )
            }
            Column(
                modifier = Modifier
                    .background(Off_White, RoundedCornerShape(0.dp))
                    .fillMaxHeight()
                    .weight(1f)
                    .width(100.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.weight(1f)
                ) {
                    ImageHolder(
                        upperMod = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                    )
                    ImageHolder(
                        upperMod = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.weight(1f)
                ) {
                    ImageHolder(
                        upperMod = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                    )
                    ImageHolder(
                        upperMod = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                    )
                }
            }
        }
    }

    @Composable
    fun ImageHolder(
        upperMod: Modifier
    ) {
        Box(
            modifier = upperMod
                .padding(all = 3.dp)
                .background(Mulberry_Light)
        ) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "",
                tint = Mulberry_Primary,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview
@Composable
fun previewImage() {
    KnitFormUI.PictureField()
}
