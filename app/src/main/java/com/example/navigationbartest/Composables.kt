package com.example.navigationbartest

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BottomBar(navHostController: NavHostController){

    val items = listOf(
        BottomBarMenu.Book,
        BottomBarMenu.Loan,
        BottomBarMenu.Settings
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val navDestination = navBackStackEntry?.destination

    NavigationBar {
        items.forEach { item ->

            AddNavigationItem(
                screen = item,
                navHostController = navHostController,
                navDestination = navDestination
            )

        }
    }
}

@Composable
fun RowScope.AddNavigationItem(
    screen: BottomBarMenu,
    navHostController: NavHostController,
    navDestination: NavDestination?
) {
    NavigationBarItem(
        label = {
            Text(text = screen.name)
                },
        icon = {
            Icon(
                imageVector = screen.selectedIcon,
                contentDescription = screen.name
            )
        },
        selected = navDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navHostController.navigate(screen.route)
        }
    )

}

@Composable
fun BottomNavigation(navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        startDestination = BottomBarMenu.Book.route
    ) {

        composable(BottomBarMenu.Book.route) {
            BookScreen()
        }

        composable(BottomBarMenu.Loan.route) {
            LoanScreen()
        }

        composable(BottomBarMenu.Settings.route) {
            SettingsScreen()
        }
    }
}


/*
* ----- 3 SCREENS -----
* */

@Composable
fun BookScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Book screen")
    }
}

@Composable
fun LoanScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Loan screen")
    }
}

@Composable
fun SettingsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Settings screen")
    }
}