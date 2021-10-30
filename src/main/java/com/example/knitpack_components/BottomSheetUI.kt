package com.example.knitpack_components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
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

val yarnWeightList: List<String> = listOf(
    "Superfine",
    "Fine",
    "Light",
    "Medium",
    "Bulky",
    "Super Bulky",
    "Jumbo",
)

fun List<String>.mapToPatternChoice(): List<DialogChoice> = this.map {
    DialogChoice.PatternChoice(it)
}


fun List<String>.mapToYarnChoice() = this.map {
    DialogChoice.YarnChoice(it)
}


object BottomSheetUI {
    @Composable
    fun ListSelectDialog(
        showDialog: Boolean,
        choices: List<DialogChoice>,
        setShowDialog: (Boolean) -> Unit,
        onChoose: (DialogChoice) -> Unit
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
                            when (choices[0]) {
                                is DialogChoice.PatternChoice -> Text(text = "Patterns")

                                is DialogChoice.YarnChoice -> Text(text = "Yarn")
                            }
                        }
                        itemsIndexed(choices) { i, dChoice ->
                            Text(
                                text = dChoice.choice,
                                style = Typography.body1,
                                modifier = Modifier.clickable {
                                    onChoose(dChoice)
                                    setShowDialog(false)
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


sealed class DialogChoice(val choice: String) {
    data class PatternChoice(val value: String) : DialogChoice(value)
    data class YarnChoice(val value: String) : DialogChoice(value)
}

@Preview
@Composable
fun previewDialog() {
//    Surface(modifier = Modifier.fillMaxSize()) {
//        BottomSheetUI.ListSelectDialog(true, patternsList) {
//
//        }
//    }
}
