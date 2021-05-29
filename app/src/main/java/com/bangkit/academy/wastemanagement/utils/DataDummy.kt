package com.bangkit.academy.wastemanagement.utils

import com.bangkit.academy.wastemanagement.data.source.local.entity.ContentEntity
import com.bangkit.academy.wastemanagement.data.source.local.entity.WasteEntity

object DataDummy {

    fun generateDummyWaste(): List<WasteEntity> {
        val wasteList = ArrayList<WasteEntity>()

        wasteList.add(
            WasteEntity(
                1,
                "Battery",
                "Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.",
            ),
        )

        wasteList.add(
            WasteEntity(
                2,
                "Brown-glass",
                "Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.",
            ),
        )

        wasteList.add(
            WasteEntity(
                3,
                "Biological",
                "Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.",
            ),
        )

        wasteList.add(
            WasteEntity(
                4,
                "Cardboard",
                "Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.",
            ),
        )

        wasteList.add(
            WasteEntity(
                5,
                "Clothes",
                "Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.",
            ),
        )

        return wasteList
    }

    fun generateDummyContent(): List<ContentEntity> {
        val contentList = ArrayList<ContentEntity>()

        contentList.add(
            ContentEntity(
                1,
                "Kaleng",
                "Biological",
                "Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.",
                "https://upload.wikimedia.org/wikipedia/commons/f/ff/Drinking_can_ring-pull_tab.jpg"
            )
        )

        contentList.add(
            ContentEntity(
                2,
                "Kaleng",
                "Biological",
                "Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.",
                "https://upload.wikimedia.org/wikipedia/commons/f/ff/Drinking_can_ring-pull_tab.jpg"
            )
        )

        contentList.add(
            ContentEntity(
                3,
                "Kaleng",
                "Biological",
                "Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.",
                "https://upload.wikimedia.org/wikipedia/commons/f/ff/Drinking_can_ring-pull_tab.jpg"
            )
        )

        contentList.add(
            ContentEntity(
                4,
                "Kaleng",
                "Biological",
                "Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.",
                "https://upload.wikimedia.org/wikipedia/commons/f/ff/Drinking_can_ring-pull_tab.jpg"
            )
        )

        contentList.add(
            ContentEntity(
                5,
                "Kaleng",
                "Biological",
                "Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.Kaleng adalah salah satu waste.",
                "https://upload.wikimedia.org/wikipedia/commons/f/ff/Drinking_can_ring-pull_tab.jpg"
            )
        )
        return contentList
    }
}