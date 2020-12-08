package jp.shiita.enumsettypeconverter

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HogeEntity::class], version = 1)
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
