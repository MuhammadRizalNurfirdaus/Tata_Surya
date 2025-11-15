package com.pab.tata_surya.model

data class CelestialObject(
    val name: String,
    val imageRes: Int,
    val mass: String,
    val diameterKm: String,
    val orbitPeriod: String,
    val distanceFromSunKm: String,
    val description: String,
    val satellites: List<String>
)
