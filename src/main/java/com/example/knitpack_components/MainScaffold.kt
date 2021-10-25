package com.example.knitpack_components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.knitpacktheme.KnitPackIcons
import com.example.knitpacktheme.theme.Mid_Grey
import com.example.knitpacktheme.theme.Mulberry_Primary
import com.example.knitpacktheme.theme.Off_White

data class MainIconData(
    val iconRes: Int,
    val routeName: String,
    val iconDesc: String
)

val iconList = listOf(
    MainIconData(KnitPackIcons.LOYALTY, KnitNavRoutes.PatternsRoutes.PatternGraphRoot.route, "Patterns"),
    MainIconData(KnitPackIcons.PLAY_CIRCLE, KnitNavRoutes.TutorialsRoutes.TutorialGraphRoot.route, "Tutorials"),
    MainIconData(KnitPackIcons.GROUP, KnitNavRoutes.SocialsRoutes.SocialGraphRoot.route, "Social"),
    MainIconData(KnitPackIcons.PERSON, KnitNavRoutes.PersonalsRoutes.PersonalGraphRoot.route, "Personal")
)

@Composable
fun MainScaffold(
    onAdd: () -> Unit,
    onNavigate: (String) -> Unit,
    isSelected: (String) -> Boolean,
    content: @Composable () -> Unit
) {
    Scaffold(
        isFloatingActionButtonDocked = true,
        topBar = {
            Column {
                TopAppBar(
                    title = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(text = "App bar")
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(
                                Icons.Filled.Menu,
                                contentDescription = ""
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(
                                Icons.Filled.Notifications,
                                contentDescription = ""
                            )
                        }
                    },
                    backgroundColor = MaterialTheme.colors.background,
                    elevation = 0.dp
                )
                TabView()
            }

        },
        bottomBar = {

            BottomAppBar(
                backgroundColor = Color.LightGray,
                cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(percent = 50)
                ),
                contentPadding = PaddingValues(all = 0.dp)
            ) {

                iconList.forEach {
                    BottomNavigationItem(
                        selected = isSelected(it.routeName),
                        onClick = { onNavigate(it.routeName) },
                        icon = {
                            Icon(
                                painterResource(id = it.iconRes),
                                contentDescription = it.iconDesc,
                            )
                        },
                        label = {
                            Text(text = it.iconDesc, color = MaterialTheme.colors.primary)
                        },
                        selectedContentColor = Mulberry_Primary,
                        unselectedContentColor = Mid_Grey
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onAdd() },
                backgroundColor = Mulberry_Primary
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "",
                    tint = Off_White
                )
            }
        }
    ) {
        content()
    }
}


sealed class KnitNavRoutes {
    sealed class PatternsRoutes(val route: String) : KnitNavRoutes() {
        object PatternGraphRoot : PatternsRoutes("PatternRoot")
        object PatternFirst : PatternsRoutes("PatternFirst")
        object PatternSecond : PatternsRoutes("PatternSecond")
    }

    sealed class TutorialsRoutes(val route: String) : KnitNavRoutes() {
        object TutorialGraphRoot : TutorialsRoutes("TutorialRoot")
        object TutorialFirst : TutorialsRoutes("TutorialFirst")
        object TutorialSecond : TutorialsRoutes("TutorialSecond")
    }

    sealed class SocialsRoutes(val route: String) : KnitNavRoutes() {
        object SocialGraphRoot : SocialsRoutes("SocialRoot")
        object SocialFirst : SocialsRoutes("SocialFirst")
        object SocialSecond : SocialsRoutes("SocialSecond")
    }

    sealed class PersonalsRoutes(val route: String) : KnitNavRoutes() {
        object PersonalGraphRoot : PersonalsRoutes("PersonalRoot")
        object PersonalFirst : PersonalsRoutes("PersonalFirst")
        object PersonalSecond : PersonalsRoutes("TutorialSecond")
    }
}
