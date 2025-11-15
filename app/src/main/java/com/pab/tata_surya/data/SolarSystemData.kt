package com.pab.tata_surya.data

import com.pab.tata_surya.R
import com.pab.tata_surya.model.CelestialObject

// Data objek tata surya untuk daftar dan detail
object SolarSystemData {
    // Daftar objek-objek di tata surya
    val objects: List<CelestialObject> by lazy {
        listOf(
            CelestialObject(
                name = "Matahari",
                imageRes = R.drawable.matahari, // gunakan foto matahari
                mass = "1.989 × 10^30 kg",
                diameterKm = "1,391,016",
                orbitPeriod = "-",
                distanceFromSunKm = "0",
                description = "Matahari adalah bintang deret utama tipe-G yang menjadi pusat Tata Surya. Energi dari reaksi fusi nuklir di intinya memancarkan cahaya dan panas yang memungkinkan kehidupan di Bumi.",
                satellites = listOf()
            ),
            CelestialObject(
                name = "Merkurius",
                imageRes = R.drawable.merkurius,
                mass = "3.285 × 10^23 kg",
                diameterKm = "4,879",
                orbitPeriod = "88 hari",
                distanceFromSunKm = "57,909,227",
                description = "Merkurius adalah planet terkecil dan terdekat ke Matahari. Permukaannya dipenuhi kawah mirip Bulan dan tidak memiliki atmosfer tebal sehingga suhu ekstrem terjadi antara siang dan malam.",
                satellites = listOf()
            ),
            CelestialObject(
                name = "Venus",
                imageRes = R.drawable.venus,
                mass = "4.867 × 10^24 kg",
                diameterKm = "12,104",
                orbitPeriod = "225 hari",
                distanceFromSunKm = "108,209,475",
                description = "Venus memiliki atmosfer sangat tebal yang didominasi karbon dioksida dan awan asam sulfat, menciptakan efek rumah kaca ekstrem sehingga menjadi planet terpanas di Tata Surya.",
                satellites = listOf()
            ),
            CelestialObject(
                name = "Bumi",
                imageRes = R.drawable.bumi,
                mass = "5.972 × 10^24 kg",
                diameterKm = "12,742",
                orbitPeriod = "365.25 hari",
                distanceFromSunKm = "149,598,023",
                description = "Bumi adalah satu-satunya planet yang diketahui mendukung kehidupan dengan atmosfer yang seimbang, keberadaan air cair melimpah, dan medan magnet pelindung dari radiasi kosmik.",
                satellites = listOf("Bulan")
            ),
            CelestialObject(
                name = "Bulan",
                imageRes = R.drawable.bulan,
                mass = "7.342 × 10^22 kg",
                diameterKm = "3,474",
                orbitPeriod = "27.3 hari",
                distanceFromSunKm = "149,598,023 (mengikuti Bumi)",
                description = "Bulan adalah satelit alami Bumi yang memengaruhi pasang surut laut dan stabilitas sumbu rotasi Bumi. Permukaannya dipenuhi kawah akibat tabrakan meteorit dan memiliki maria gelap dari lava purba.",
                satellites = listOf()
            ),
            CelestialObject(
                name = "Mars",
                imageRes = R.drawable.mars,
                mass = "6.39 × 10^23 kg",
                diameterKm = "6,779",
                orbitPeriod = "687 hari",
                distanceFromSunKm = "227,943,824",
                description = "Mars dikenal sebagai Planet Merah karena kandungan besi oksida di permukaannya. Memiliki gunung tertinggi Olympus Mons dan lembah raksasa Valles Marineris, menjadi fokus eksplorasi untuk tanda kehidupan masa lalu.",
                satellites = listOf("Phobos", "Deimos")
            ),
            CelestialObject(
                name = "Jupiter",
                imageRes = R.drawable.jupiter,
                mass = "1.898 × 10^27 kg",
                diameterKm = "139,820",
                orbitPeriod = "11.86 tahun",
                distanceFromSunKm = "778,340,821",
                description = "Jupiter adalah planet terbesar dengan atmosfer hidrogen dan helium. Bintik Merah Besar adalah badai raksasa yang telah berlangsung selama berabad-abad. Memiliki banyak bulan termasuk Europa yang mengandung lautan bawah permukaan.",
                satellites = listOf("Io", "Europa", "Ganymede", "Callisto")
            ),
            CelestialObject(
                name = "Saturnus",
                imageRes = R.drawable.saturnus,
                mass = "5.683 × 10^26 kg",
                diameterKm = "116,460",
                orbitPeriod = "29.5 tahun",
                distanceFromSunKm = "1,426,666,422",
                description = "Saturnus terkenal karena sistem cincin spektakuler yang terdiri dari partikel es dan batu. Bulan-bulannya seperti Titan dan Enceladus menarik secara ilmiah karena potensi kondisi yang mendukung kehidupan.",
                satellites = listOf("Titan", "Enceladus", "Rhea")
            ),
            CelestialObject(
                name = "Uranus",
                imageRes = R.drawable.uranus,
                mass = "8.681 × 10^25 kg",
                diameterKm = "50,724",
                orbitPeriod = "84 tahun",
                distanceFromSunKm = "2,870,658,186",
                description = "Uranus adalah planet es raksasa dengan atmosfer kaya metana yang memberi warna kebiruan. Sumbu rotasinya miring ekstrem sehingga perubahan musim berlangsung unik dan berkepanjangan.",
                satellites = listOf("Miranda", "Ariel", "Umbriel", "Titania", "Oberon")
            ),
            CelestialObject(
                name = "Neptunus",
                imageRes = R.drawable.neptunus,
                mass = "1.024 × 10^26 kg",
                diameterKm = "49,244",
                orbitPeriod = "164.8 tahun",
                distanceFromSunKm = "4,498,396,441",
                description = "Neptunus adalah planet es raksasa terjauh dengan angin tercepat yang pernah tercatat di Tata Surya. Memiliki warna biru dalam karena metana di atmosfernya.",
                satellites = listOf("Triton")
            ),
            CelestialObject(
                name = "Pluto",
                imageRes = R.drawable.pluto, // pakai pluto.png
                mass = "1.309 × 10^22 kg",
                diameterKm = "2,377",
                orbitPeriod = "248 tahun",
                distanceFromSunKm = "5,906,376,272",
                description = "Pluto adalah planet katai di Sabuk Kuiper dengan orbit elips dan permukaan yang terdiri dari es nitrogen, metana, dan karbon monoksida. Hubungannya dengan bulan Charon hampir seperti sistem biner.",
                satellites = listOf("Charon", "Nix", "Hydra")
            )
        )
    }

    // Mencari objek berdasarkan nama
    fun findByName(name: String): CelestialObject? = objects.find { it.name == name }
}
