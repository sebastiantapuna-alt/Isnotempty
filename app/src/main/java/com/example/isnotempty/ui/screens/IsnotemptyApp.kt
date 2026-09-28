package com.example.isnotempty.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.example.isnotempty.R
import com.example.isnotempty.ui.theme.obtenerTema

enum class AppDestinations(
    val label: String,
    val icon: Int,
) {
    HOME("Home", R.drawable.ic_home),
    FAVORITES("Favorites", R.drawable.ic_favorite),
    PROFILE("Profile", R.drawable.ic_account_box),
}

@PreviewScreenSizes
@Composable
fun IsnotemptyApp() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    val numeroTema = when (currentDestination) {
        AppDestinations.HOME -> 10
        AppDestinations.FAVORITES -> 9
        AppDestinations.PROFILE -> 3
    }
    //favs 10(0.2 o 0.3), 9(0.0), 3(0.1), 5 masomenos, la 7 esta pasable, el 4 tuneandolo
    //la 6 tiene algo

    val temaActual = obtenerTema(numeroTema)

    NavigationSuiteScaffold(
        navigationSuiteColors = NavigationSuiteDefaults.colors(
            navigationBarContainerColor = temaActual.botones,
            navigationBarContentColor = temaActual.fondo
        ),
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            painterResource(it.icon),
                            contentDescription = it.label
                        )
                    },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            val name = when (currentDestination) {
                AppDestinations.HOME -> "suchi"
                AppDestinations.FAVORITES -> "fish"
                AppDestinations.PROFILE -> "alexis"
            }
            when (currentDestination) {

                AppDestinations.HOME-> {
                    Greeting(
                        name = name,
                        modifier = Modifier.padding(innerPadding),
                        currentDestination = currentDestination,
                        tema = temaActual
                    )
                }
                AppDestinations.FAVORITES -> {
                    Greeting2(
                        name = name,
                        modifier = Modifier.padding(innerPadding),
                        currentDestination = currentDestination,
                        tema = temaActual
                    )
                }
                AppDestinations.PROFILE -> {
                    Greeting(
                        name = name,
                        modifier = Modifier.padding(innerPadding),
                        currentDestination = currentDestination,
                        tema = temaActual
                    )
                }
            }
        }
    }
}
