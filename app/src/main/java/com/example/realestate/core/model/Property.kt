package com.example.realestate.core.model

data class Property(
    val id: Int,
    val title: String,
    val address: String,
    val price: Int,
    val beds: Int,
    val baths: Int,
    val area: Int,
    val imageName: String,
    val isGarage: Boolean
)
