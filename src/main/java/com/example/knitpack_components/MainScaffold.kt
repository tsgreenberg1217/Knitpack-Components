package com.example.knitpack_components

import androidx.annotation.StringRes
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.knitpacktheme.KnitPackIcons
import com.example.knitpacktheme.theme.Mid_Grey
import com.example.knitpacktheme.theme.Mulberry_Primary
import com.example.knitpacktheme.theme.Off_White

data class MainIconData(
    val iconRes: Int,
    val routeObj: MainPageRoute
)

val iconList = listOf(
    MainIconData(KnitPackIcons.LOYALTY, MainPageRoute.Patterns),
    MainIconData(KnitPackIcons.PLAY_CIRCLE, MainPageRoute.Tutorials),
    MainIconData(KnitPackIcons.GROUP, MainPageRoute.Social),
    MainIconData(KnitPackIcons.PERSON, MainPageRoute.Personal)
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
                    val descString = stringResource(id = it.routeObj.resId)
                    BottomNavigationItem(
                        selected = isSelected(it.routeObj.route),
                        onClick = { onNavigate(it.routeObj.route) },
                        icon = {
                            Icon(
                                painterResource(id = it.iconRes),
                                contentDescription = descString,
                            )
                        },
                        label = {
                            Text(text = descString, color = MaterialTheme.colors.primary)
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

sealed class MainPageRoute(val route: String, @StringRes val resId: Int) {
    object Patterns : MainPageRoute("route_patterns", R.string.title_patterns)
    object Tutorials : MainPageRoute("route_tutorials", R.string.title_tutorials)
    object Social : MainPageRoute("route_social", R.string.title_social)
    object Personal : MainPageRoute("route_personal", R.string.title_personal)
}