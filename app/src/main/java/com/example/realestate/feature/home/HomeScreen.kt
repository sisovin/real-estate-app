package com.example.realestate.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.realestate.core.model.Property
import com.example.realestate.ui.components.CategoryRow
import com.example.realestate.ui.components.PropertyCard
import com.example.realestate.ui.components.RealEstateSearchBar
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.realestate.feature.favorites.FavoritesViewModel
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController,
    favoritesViewModel: FavoritesViewModel = viewModel()
) {
    val properties = listOf(
        Property(1, "Modern Villa", "123 Maple St, California", 250000, 4, 3, 2400, "pic_1", true),
        Property(2, "Luxury Apartment", "456 Oak Ave, New York", 180000, 2, 2, 1200, "pic_2", false),
        Property(3, "Cosy House", "789 Pine Rd, Texas", 320000, 3, 2, 1800, "pic_3", true),
        Property(4, "Skyline Penthouse", "101 View Blvd, Miami", 550000, 5, 4, 3500, "pic_4", true)
    )

    val favoriteProperties by favoritesViewModel.favoriteProperties.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Header
        HeaderSection(navController)

        // Search Bar
        RealEstateSearchBar(modifier = Modifier.padding(top = 16.dp))

        // Category Row
        CategoryRow()

        // Property List
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(bottom = 100.dp) // Bottom padding for floating nav
        ) {
            item {
                Text(
                    text = "Nearby Properties",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ),
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            items(properties) { property ->
                val isFavorite = favoriteProperties.any { it.id == property.id }
                PropertyCard(
                    property = property,
                    isFavorite = isFavorite,
                    onFavoriteToggle = { favoritesViewModel.toggleFavorite(it) },
                    onViewDetail = { prop ->
                        navController.navigate("property_detail/${prop.id}")
                    }
                )
            }
        }
    }
}

@Composable
fun HeaderSection(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile Image
        Box(
            modifier = Modifier
                .size(45.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
        ) {
            // Placeholder for profile image
            // Image(painter = painterResource(id = R.drawable.profile_placeholder), ...)
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Location",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
            Text(
                text = "Los Angeles, CA",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
            )
        }

        // Notification Icon
        Surface(
            modifier = Modifier.size(45.dp),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        ) {
            Box(contentAlignment = Alignment.Center) {
                IconButton(onClick = { navController.navigate("notifications") }) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notifications",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}
