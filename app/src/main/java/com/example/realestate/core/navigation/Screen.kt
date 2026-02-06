package com.example.realestate.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen("home", "Home", Icons.Default.Home)
    object Favorites : Screen("favorites", "Favorites", Icons.Default.Favorite)
    object Profile : Screen("profile", "Profile", Icons.Default.Person)
    object PropertyDetail : Screen("property_detail/{propertyId}", "Property Detail", Icons.Default.Home)
    object ContactAgent : Screen("contact_agent/{propertyId}", "Contact Agent", Icons.Default.Home)
    object EditProfile : Screen("edit_profile", "Edit Profile", Icons.Default.Home)
    object Settings : Screen("settings", "Settings", Icons.Default.Home)
    object Notification : Screen("notifications", "Notifications", Icons.Default.Home)

    companion object {
        val bottomNavItems = listOf(Home, Favorites, Profile)
    }
}
