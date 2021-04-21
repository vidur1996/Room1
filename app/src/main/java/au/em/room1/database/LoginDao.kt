package au.em.room1.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LoginDao {

    @Query("SELECT * FROM Login WHERE username=(:username)")
    suspend fun loadEmail(username:String):List<Login>

    @Insert
    suspend fun insertAll(vararg login:Login)


    @Query("SELECT password FROM Login WHERE username=(:username)")
    suspend fun checkPassword(username:String):String
}