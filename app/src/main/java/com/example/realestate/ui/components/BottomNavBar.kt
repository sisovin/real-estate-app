package com.example.realestate.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.realestate.core.navigation.Screen

@Composable
fun FloatingBottomNavBar(
    currentRoute: String?,
    onNavigate: (Screen) -> Unit
) {
    Surface(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 24.dp)
            .height(72.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(36.dp)),
        color = Color(0xFF1A1A1A), // Dark background
        tonalElevation = 8.dp
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Screen.bottomNavItems.forEach { screen ->
                val isSelected = currentRoute == screen.route
                val tint = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray

                IconButton(onClick = { onNavigate(screen) }) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = screen.icon,
                            contentDescription = screen.title,
                            tint = tint,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }
            }
        }
    }
}
