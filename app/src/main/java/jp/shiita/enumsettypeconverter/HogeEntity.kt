package jp.shiita.enumsettypeconverter

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HogeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val animals: Set<Animal>,
    val seasons: Set<Season>
)

enum class Animal {
    DOG, CAT, BIRD
}

enum class Season {
    SPRING, SUMMER, AUTUMN, WINTER
}
