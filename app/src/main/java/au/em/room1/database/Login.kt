package au.em.room1.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Login(
    @PrimaryKey val username:String,
    val name:String,
    val email:String,
    val password:String
)