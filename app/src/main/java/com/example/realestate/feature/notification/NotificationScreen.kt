package com.example.realestate.feature.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(
    navController: NavController
) {
    // Sample notifications data
    val notifications = listOf(
        Notification(
            id = 1,
            title = "New Property Available",
            message = "A new luxury villa has been listed in your area. Check it out!",
            timestamp = "2 hours ago",
            isRead = false,
            type = NotificationType.Property
        ),
        Notification(
            id = 2,
            title = "Price Drop Alert",
            message = "The Modern Villa you viewed has a price reduction of $10,000!",
            timestamp = "1 day ago",
            isRead = false,
            type = NotificationType.Price
        ),
        Notification(
            id = 3,
            title = "Appointment Reminder",
            message = "Your property viewing appointment is tomorrow at 2 PM.",
            timestamp = "2 days ago",
            isRead = true,
            type = NotificationType.Appointment
        ),
        Notification(
            id = 4,
            title = "Welcome to RealEstate App",
            message = "Thanks for joining! Explore properties and find your dream home.",
            timestamp = "1 week ago",
            isRead = true,
            type = NotificationType.Welcome
        ),
        Notification(
            id = 5,
            title = "Market Update",
            message = "Property prices in California have increased by 3% this month.",
            timestamp = "1 week ago",
            isRead = true,
            type = NotificationType.Market
        )
    )

    val unreadCount = notifications.count { !it.isRead }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notifications") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    if (unreadCount > 0) {
                        Text(
                            text = "$unreadCount",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(end = 16.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        if (notifications.isEmpty()) {
            // Empty state
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = "No notifications",
                        modifier = Modifier.size(64.dp),
                        tint = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "No notifications yet",
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "We'll notify you when there are updates",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(MaterialTheme.colorScheme.background),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(notifications) { notification ->
                    NotificationItem(
                        notification = notification,
                        onClick = {
                            // Mark as read or navigate based on type
                            // For now, just toggle read status
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationItem(
    notification: Notification,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (!notification.isRead)
                MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.1f)
            else
                MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            // Notification Icon
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        color = getNotificationColor(notification.type),
                        shape = androidx.compose.foundation.shape.CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = getNotificationIcon(notification.type),
                    contentDescription = notification.type.name,
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = notification.title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = notification.message,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = notification.timestamp,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }

            if (!notification.isRead) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = androidx.compose.foundation.shape.CircleShape
                        )
                )
            }
        }
    }
}

fun getNotificationIcon(type: NotificationType): androidx.compose.ui.graphics.vector.ImageVector {
    return when (type) {
        NotificationType.Property -> Icons.Filled.Notifications
        NotificationType.Price -> Icons.Filled.Star
        NotificationType.Appointment -> Icons.Filled.Info
        NotificationType.Welcome -> Icons.Filled.Person
        NotificationType.Market -> Icons.Filled.LocationOn
    }
}

fun getNotificationColor(type: NotificationType): Color {
    return when (type) {
        NotificationType.Property -> Color(0xFF4CAF50) // Green
        NotificationType.Price -> Color(0xFFFF9800) // Orange
        NotificationType.Appointment -> Color(0xFF2196F3) // Blue
        NotificationType.Welcome -> Color(0xFF9C27B0) // Purple
        NotificationType.Market -> Color(0xFF607D8B) // Blue Grey
    }
}

data class Notification(
    val id: Int,
    val title: String,
    val message: String,
    val timestamp: String,
    val isRead: Boolean,
    val type: NotificationType
)

enum class NotificationType {
    Property,
    Price,
    Appointment,
    Welcome,
    Market
}
