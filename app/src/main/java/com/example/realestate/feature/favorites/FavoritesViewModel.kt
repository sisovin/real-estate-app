package com.example.realestate.feature.favorites

import androidx.lifecycle.ViewModel
import com.example.realestate.core.model.Property
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FavoritesViewModel : ViewModel() {

    private val _favoriteProperties = MutableStateFlow<List<Property>>(emptyList())
    val favoriteProperties: StateFlow<List<Property>> = _favoriteProperties

    fun toggleFavorite(property: Property) {
        val currentFavorites = _favoriteProperties.value.toMutableList()
        if (currentFavorites.any { it.id == property.id }) {
            currentFavorites.removeIf { it.id == property.id }
        } else {
            currentFavorites.add(property)
        }
        _favoriteProperties.value = currentFavorites
    }
}