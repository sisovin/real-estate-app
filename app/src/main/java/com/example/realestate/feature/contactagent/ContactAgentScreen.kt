package com.example.realestate.feature.contactagent

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactAgentScreen(
    navController: NavController,
    propertyId: String
) {
    // For demo, hardcode agent info based on propertyId
    val agent = when (propertyId) {
        "1" -> Agent("John Smith", "john.smith@realestate.com", "+1 (555) 123-4567", "Experienced real estate agent specializing in luxury villas.")
        "2" -> Agent("Jane Doe", "jane.doe@realestate.com", "+1 (555) 234-5678", "Expert in urban apartments and modern living spaces.")
        "3" -> Agent("Bob Johnson", "bob.johnson@realestate.com", "+1 (555) 345-6789", "Specialist in cozy family homes and suburban properties.")
        "4" -> Agent("Alice Brown", "alice.brown@realestate.com", "+1 (555) 456-7890", "Luxury penthouse and high-end property expert.")
        else -> Agent("Default Agent", "agent@realestate.com", "+1 (555) 000-0000", "Real estate professional ready to assist.")
    }

    val message = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Contact Agent") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
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
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Agent Avatar
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Agent Avatar",
                    modifier = Modifier.size(60.dp),
                    tint = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Agent Name
            Text(
                text = agent.name,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Agent Bio
            Text(
                text = agent.bio,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Contact Info
            ContactInfoCard(
                icon = Icons.Default.Email,
                label = "Email",
                value = agent.email
            )

            ContactInfoCard(
                icon = Icons.Default.Phone,
                label = "Phone",
                value = agent.phone
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Message Field
            OutlinedTextField(
                value = message.value,
                onValueChange = { message.value = it },
                label = { Text("Your Message") },
                modifier = Modifier.fillMaxWidth(),
                maxLines = 5,
                placeholder = { Text("Type your message here...") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Send Button
            Button(
                onClick = {
                    // TODO: Implement send message functionality
                    // For now, just show a snackbar or toast
                    // You can use a ViewModel to handle sending
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Send Message",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactInfoCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    value: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = label,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
                Text(
                    text = value,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

data class Agent(
    val name: String,
    val email: String,
    val phone: String,
    val bio: String
)
