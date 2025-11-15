package com.pab.tata_surya

import com.pab.tata_surya.data.SolarSystemData
import org.junit.Assert.assertTrue
import org.junit.Assert.assertNotNull
import org.junit.Test

class SolarSystemDataTest {
    @Test
    fun objects_count_at_least_ten() {
        assertTrue("Jumlah objek harus >= 10", SolarSystemData.objects.size >= 10)
    }

    @Test
    fun find_earth() {
        val earth = SolarSystemData.findByName("Bumi")
        assertNotNull("Bumi harus ditemukan", earth)
        assertTrue("Diameter Bumi harus tidak kosong", earth!!.diameterKm.isNotBlank())
    }
}

