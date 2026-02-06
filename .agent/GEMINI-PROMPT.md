You are an expert Android developer specializing in Jetpack Compose, Material 3, 
modular architecture, and clean UI component design. Generate a complete, 
production‑ready implementation for a modern Real Estate mobile app screen.

Follow these instructions precisely:

====================================================
1. PROJECT STRUCTURE & ARCHITECTURE
====================================================
Create a modular package structure:

core/
  model/
  navigation/
  util/

feature/
  home/

ui/
  components/

Use clean architecture principles:
- Immutable data models (val)
- Stateless composables where possible
- Reusable UI components
- No deprecated APIs

====================================================
2. DATA MODEL
====================================================
Create a Kotlin data class named `Property` with fields:
- id: Int
- title: String
- address: String
- price: Int
- beds: Int
- baths: Int
- area: Int
- imageName: String
- isGarage: Boolean

All fields must be immutable.

====================================================
3. NAVIGATION SETUP
====================================================
Create a navigation system using Navigation Compose:
- Use a `Scaffold` as the root layout
- Include logic to show/hide the bottom navigation bar based on route
- Use `launchSingleTop = true` to prevent duplicate destinations
- Create a sealed class or enum for routes

Screens required:
- HomeScreen (main screen)

====================================================
4. HOME SCREEN LAYOUT
====================================================
Build the Home screen using Jetpack Compose with the following UI sections:

A) HEADER
- A Row with:
  - User profile image on the left
  - Notification bell icon on the right

B) SEARCH BAR
- Custom search bar with:
  - Rounded corners (30dp)
  - Placeholder text
  - Leading search icon

C) CATEGORY ROW
- A horizontally scrollable LazyRow
- Categories: House, Apartment, Villa
- Each category is its own composable
- Use Modifier.weight(1f) for even spacing

D) PROPERTY LIST
- A LazyColumn containing property cards
- Add bottom padding (100dp) so last item is not hidden behind bottom nav

====================================================
5. PROPERTY CARD COMPONENT
====================================================
Create a reusable composable `PropertyCard()` with:

- A Box containing:
  - Property image with rounded corners
  - Floating price tag aligned top‑start or top‑end

- Below the image:
  - Title
  - Address
  - Row of meta chips:
    - Beds
    - Baths
    - Area (sqft)

Use:
- RoundedCornerShape
- Clip modifiers
- Material 3 styling

====================================================
6. FLOATING BOTTOM NAVIGATION BAR
====================================================
Create a custom bottom navigation bar with:
- Floating appearance (detached from edges)
- Dark background
- Rounded corners
- Icons for Home, Favorites, Profile

====================================================
7. UTILITY FUNCTION
====================================================
Create a helper function:
`getDrawableId(context: Context, name: String): Int`
This should convert a string like "pic_1" into a drawable resource ID.

====================================================
8. CODE QUALITY REQUIREMENTS
====================================================
- Use Material 3 components
- Use Kotlin DSL conventions
- Use best Compose practices
- No placeholder TODOs
- No deprecated APIs
- All composables previewable where possible

====================================================
9. OUTPUT FORMAT
====================================================
Generate:
- All Kotlin files
- Full composable implementations
- Navigation setup
- Data model
- Utility functions
- Bottom navigation
- Category row
- Property card
- Home screen

Do NOT include Gradle files or assets. Only Kotlin source code.

====================================================

Generate the complete implementation now.
