package com.example.realestate.feature.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
fun SettingsScreen(
    navController: NavController
) {
    // Settings state
    val notificationsEnabled = remember { mutableStateOf(true) }
    val darkModeEnabled = remember { mutableStateOf(false) }
    val locationEnabled = remember { mutableStateOf(true) }
    val emailUpdatesEnabled = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState())
        ) {
            // Account Settings Section
            SettingsSection(title = "Account Settings") {
                SettingsItem(
                    icon = Icons.Filled.Person,
                    title = "Profile Information",
                    subtitle = "Update your personal details",
                    onClick = { /* Navigate to profile edit */ }
                )
                SettingsItem(
                    icon = Icons.Filled.Lock,
                    title = "Change Password",
                    subtitle = "Update your account password",
                    onClick = { /* Navigate to change password */ }
                )
                SettingsItem(
                    icon = Icons.Filled.Email,
                    title = "Email Preferences",
                    subtitle = "Manage email notifications",
                    onClick = { /* Navigate to email settings */ }
                )
            }

            // App Preferences Section
            SettingsSection(title = "App Preferences") {
                SettingsSwitchItem(
                    icon = Icons.Filled.Notifications,
                    title = "Push Notifications",
                    subtitle = "Receive notifications about new properties",
                    checked = notificationsEnabled.value,
                    onCheckedChange = { notificationsEnabled.value = it }
                )
                SettingsSwitchItem(
                    icon = Icons.Filled.Settings,
                    title = "Dark Mode",
                    subtitle = "Switch to dark theme",
                    checked = darkModeEnabled.value,
                    onCheckedChange = { darkModeEnabled.value = it }
                )
                SettingsSwitchItem(
                    icon = Icons.Filled.LocationOn,
                    title = "Location Services",
                    subtitle = "Allow access to location for better recommendations",
                    checked = locationEnabled.value,
                    onCheckedChange = { locationEnabled.value = it }
                )
                SettingsItem(
                    icon = Icons.Filled.Info,
                    title = "Language",
                    subtitle = "English",
                    onClick = { /* Navigate to language selection */ }
                )
            }

            // Privacy & Security Section
            SettingsSection(title = "Privacy & Security") {
                SettingsItem(
                    icon = Icons.Filled.Lock,
                    title = "Privacy Policy",
                    subtitle = "Read our privacy policy",
                    onClick = { /* Navigate to privacy policy */ }
                )
                SettingsItem(
                    icon = Icons.Filled.Person,
                    title = "Data & Privacy",
                    subtitle = "Manage your data and privacy settings",
                    onClick = { /* Navigate to data settings */ }
                )
                SettingsSwitchItem(
                    icon = Icons.Filled.Email,
                    title = "Marketing Emails",
                    subtitle = "Receive promotional emails",
                    checked = emailUpdatesEnabled.value,
                    onCheckedChange = { emailUpdatesEnabled.value = it }
                )
            }

            // Support Section
            SettingsSection(title = "Support") {
                SettingsItem(
                    icon = Icons.Filled.Info,
                    title = "Help Center",
                    subtitle = "Get help and support",
                    onClick = { /* Navigate to help center */ }
                )
                SettingsItem(
                    icon = Icons.Filled.Star,
                    title = "Send Feedback",
                    subtitle = "Share your thoughts with us",
                    onClick = { /* Navigate to feedback */ }
                )
                SettingsItem(
                    icon = Icons.Filled.Info,
                    title = "About",
                    subtitle = "App version and information",
                    onClick = { /* Navigate to about */ }
                )
            }

            // Account Actions Section
            SettingsSection(title = "Account Actions") {
                SettingsItem(
                    icon = Icons.Filled.ExitToApp,
                    title = "Sign Out",
                    subtitle = "Sign out of your account",
                    onClick = { /* Handle sign out */ },
                    textColor = MaterialTheme.colorScheme.error
                )
                SettingsItem(
                    icon = Icons.Filled.Delete,
                    title = "Delete Account",
                    subtitle = "Permanently delete your account",
                    onClick = { /* Handle account deletion */ },
                    textColor = MaterialTheme.colorScheme.error
                )
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsSection(
    title: String,
    content: @Composable () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        content()
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    subtitle: String? = null,
    onClick: () -> Unit,
    textColor: Color = MaterialTheme.colorScheme.onSurface
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = textColor
                )
                subtitle?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                }
            }
            Icon(
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = "Navigate",
                tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsSwitchItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    subtitle: String? = null,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                subtitle?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                }
            }
            Switch(
                checked = checked,
                onCheckedChange = onCheckedChange
            )
        }
    }
}
