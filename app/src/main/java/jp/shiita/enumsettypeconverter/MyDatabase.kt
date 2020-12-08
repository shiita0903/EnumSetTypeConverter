package jp.shiita.enumsettypeconverter

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import jp.shiita.enumsettypeconverter.converter.AnimalConverters
import jp.shiita.enumsettypeconverter.converter.SeasonConverters

@Database(entities = [HogeEntity::class], version = 1)
@TypeConverters(AnimalConverters::class, SeasonConverters::class)
abstract class MyDatabase : RoomDatabase() {
    abstract fun hogeDao(): HogeDao

    companion object {
        private const val dbName = "my.db"

        fun createDbInstance(context: Context): MyDatabase = Room
            .databaseBuilder(context, MyDatabase::class.java, dbName)
            .fallbackToDestructiveMigration()
            .build()
    }
}
