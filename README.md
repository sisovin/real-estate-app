# 🏠 Real Estate App

A modern, beautiful Android application for browsing and managing real estate properties. Built with Jetpack Compose and Material 3 design, featuring property listings, favorites management, and detailed property views.

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack_Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Material 3](https://img.shields.io/badge/Material_3-6750A4?style=for-the-badge&logo=materialdesign&logoColor=white)

## ✨ Features

### 🏡 Property Listings
- **Browse Properties**: View a curated list of available properties
- **Property Details**: Rich property information including price, location, bedrooms, bathrooms, and square footage
- **Beautiful UI**: Modern card-based design with property images and key information

### ❤️ Favorites Management
- **Add to Favorites**: Heart icon button to save properties to favorites
- **Persistent Storage**: Favorites are maintained across app sessions
- **Favorites Screen**: Dedicated screen to view all favorited properties

### 🧭 Navigation
- **Bottom Navigation**: Easy navigation between Home, Favorites, and Profile screens
- **Property Details**: Navigate to detailed property views
- **Back Navigation**: Proper back stack management

### 🎨 Modern Design
- **Material 3**: Latest Material Design guidelines
- **Dark/Light Theme**: Automatic theme support
- **Responsive Layout**: Optimized for different screen sizes
- **Smooth Animations**: Fluid transitions and interactions

## 🚀 Getting Started

### Prerequisites

- **Android Studio**: Arctic Fox or later
- **Minimum SDK**: API 24 (Android 7.0)
- **Target SDK**: API 34 (Android 14)
- **Kotlin**: 1.8+

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/sisovin/real-estate-app.git
   cd real-estate-app
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing Android Studio project"
   - Navigate to the cloned directory and select it

3. **Sync Project**
   - Android Studio will automatically sync the project with Gradle files
   - Wait for the sync to complete

4. **Run the App**
   - Connect an Android device or start an emulator
   - Click the "Run" button (green play icon) in Android Studio
   - Select your target device/emulator

## 🏗️ Project Structure

```
real-estate-app/
├── app/
│   ├── src/main/java/com/example/realestate/
│   │   ├── core/
│   │   │   ├── model/          # Data models (Property)
│   │   │   ├── navigation/     # Navigation setup and routes
│   │   │   └── util/           # Utility classes
│   │   ├── feature/
│   │   │   ├── favorites/      # Favorites feature
│   │   │   │   ├── FavoritesScreen.kt
│   │   │   │   ├── FavoritesViewModel.kt
│   │   │   └── home/           # Home screen feature
│   │   │       └── HomeScreen.kt
│   │   │   └── propertydetail/ # Property detail feature
│   │   │       └── PropertyDetailScreen.kt
│   │   └── ui/
│   │       ├── components/     # Reusable UI components
│   │       │   ├── PropertyCard.kt
│   │       │   ├── CategoryRow.kt
│   │       │   ├── RealEstateSearchBar.kt
│   │       │   └── FloatingBottomNavBar.kt
│   │       └── theme/          # App theming
│   ├── src/main/res/           # Resources (drawables, layouts, etc.)
│   └── build.gradle            # App-level build configuration
├── build.gradle                # Project-level build configuration
├── settings.gradle             # Project settings
└── gradle.properties           # Gradle properties
```

## 🛠️ Tech Stack

### Core Technologies
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM (Model-View-ViewModel)
- **Navigation**: Navigation Compose
- **State Management**: StateFlow & LiveData

### Libraries & Dependencies
- **Compose BOM**: `androidx.compose:compose-bom:2023.08.00`
- **Material 3**: `androidx.compose.material3:material3`
- **Navigation**: `androidx.navigation:navigation-compose:2.7.5`
- **Lifecycle**: `androidx.lifecycle:lifecycle-runtime-ktx:2.6.2`
- **Activity Compose**: `androidx.activity:activity-compose:1.8.1`
- **Core KTX**: `androidx.core:core-ktx:1.12.0`

### Development Tools
- **Build System**: Gradle with Kotlin DSL
- **Testing**: JUnit 4, Espresso, Compose UI Testing
- **Linting**: Android Lint
- **IDE**: Android Studio

## 📱 Screenshots

*Add screenshots of your app here*

## 🔧 Configuration

### Build Variants
- **Debug**: Development build with debugging enabled
- **Release**: Production build with optimizations

### Environment Setup
1. **Local Properties**: Copy `local.properties.example` to `local.properties`
2. **API Keys**: Add any required API keys to `local.properties`
3. **Signing Config**: Configure signing for release builds

## 🧪 Testing

### Unit Tests
```bash
./gradlew testDebugUnitTest
```

### Instrumentation Tests
```bash
./gradlew connectedDebugAndroidTest
```

### UI Tests
```bash
./gradlew testDebugUnitTest testDebugAndroidTest
```

## 🚀 Deployment

### Debug Build
```bash
./gradlew assembleDebug
```

### Release Build
```bash
./gradlew assembleRelease
```

### Bundle Generation (AAB)
```bash
./gradlew bundleRelease
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Code Style
- Follow Kotlin coding conventions
- Use meaningful variable and function names
- Add documentation for public APIs
- Write tests for new features

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- [Jetpack Compose](https://developer.android.com/jetpack/compose) for the modern UI toolkit
- [Material Design 3](https://material.io/design) for the design system
- [Android Developers](https://developer.android.com/) for comprehensive documentation

## 📞 Support

If you have any questions or need help:

- **Issues**: [GitHub Issues](https://github.com/yourusername/real-estate-app/issues)
- **Discussions**: [GitHub Discussions](https://github.com/yourusername/real-estate-app/discussions)
- **Email**: your.email@example.com

## 🔄 Version History

### [1.0.0] - 2024-02-06
- Initial release
- Property listings with favorites functionality
- Material 3 design implementation
- Navigation between screens
- Property detail views

---

**Made with ❤️ using Jetpack Compose**
