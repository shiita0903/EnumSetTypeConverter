package jp.shiita.enumsettypeconverter

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            checkConverters()
        }
    }

    private suspend fun checkConverters() = withContext(Dispatchers.IO) {
        val database = MyDatabase.createDbInstance(this@MainActivity)
        database.clearAllTables()

        val hogeDao = database.hogeDao()
        hogeDao.upsert(
            HogeEntity(
                id = 0,
                animals = setOf(Animal.DOG, Animal.BIRD),
                seasons = setOf(Season.SUMMER, Season.WINTER)
            )
        )
        hogeDao.upsert(
            HogeEntity(
                id = 0,
                animals = emptySet(),
                seasons = Season.values().toSet()
            )
        )

        Log.d("hoge list", hogeDao.findAll().toString())
    }
}
