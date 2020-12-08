package jp.shiita.enumsettypeconverter

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HogeDao {
    @Query("SELECT * FROM HogeEntity")
    fun findAll(): List<HogeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(hogeEntity: HogeEntity)
}
