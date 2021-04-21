package au.em.room1.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Login::class),version =1)
abstract class LoginDataBase :RoomDatabase() {

    abstract fun getLoginDao(): LoginDao

    companion object {

        @Volatile
        private var instance: LoginDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }


        private fun buildDatabase(context: Context) = Room.databaseBuilder(
                context.applicationContext,
                LoginDataBase::class.java,
                "notedatabase"
        ).build()
    }

}