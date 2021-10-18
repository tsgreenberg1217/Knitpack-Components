package com.example.knitpack_components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.knitpacktheme.theme.KnitPackTheme
import com.example.knitpacktheme.theme.Typography

val patternsList: List<String> = listOf(
    "2x2 Rib",
    "1x1 Rib",
    "Garter",
    "Stockinette",
    "Moss rib",
    "Double moss rib",
    "Linen stitch",
    "Purl stitch",
    "Slip stitch",
    "K2Tog",
    "P2Tog",
    "SSK"
)

object BottomSheetUI {
    @Composable
    fun ListSelectDialog(
        showDialog: Boolean,
        choices: List<String>,
        setShowDialog: (Boolean) -> Unit
    ) {

        val dialogWidth = 300.dp
        val dialogHeight = 400.dp
        val cornerSize = 16.dp

        if (showDialog) {
            Dialog(onDismissRequest = { setShowDialog(false) }) {
                Box(
                    Modifier
                        .size(dialogWidth, dialogHeight)
                        .background(Color.White, RoundedCornerShape(cornerSize))
                        .padding(all = 8.dp)
                ) {
                    LazyColumn {
                        item { 
                            Text(text = "Patterns")
                        }
                        itemsIndexed(choices) { i, choice ->
                            Text(
                                text = choice,
                                style = Typography.body1,
                                modifier = Modifier.clickable {

                                }
                            )
                            Divider(color = Color.LightGray)
                            Spacer(modifier = Modifier.height(20.dp))
                        }
                    }
                }
            }
        }

    }
}

@Preview
@Composable
fun previewDialog() {
    Surface(modifier = Modifier.fillMaxSize()) {
        BottomSheetUI.ListSelectDialog(true, patternsList) {

        }
    }
}
