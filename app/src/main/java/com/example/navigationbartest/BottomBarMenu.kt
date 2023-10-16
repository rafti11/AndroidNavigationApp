package com.example.navigationbartest

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarMenu (
    val name: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
    ) {
    object Book : BottomBarMenu(
        name = "Book",
        route = "book",
        selectedIcon = Icons.Default.Place,
        unselectedIcon = Icons.Default.Place,
    )

    object Loan : BottomBarMenu(
        name = "Loan",
        route = "loan",
        selectedIcon = Icons.Default.Favorite,
        unselectedIcon = Icons.Default.Favorite,
    )

    object Settings : BottomBarMenu(
        name = "Settings",
        route = "settings",
        selectedIcon = Icons.Default.Settings,
        unselectedIcon = Icons.Default.Settings,
    )
}