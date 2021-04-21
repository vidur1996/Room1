package au.em.room1.database

class UserRegister {

    var name:String? = null
    var email:String?=null
    var username:String? = null
    var password:String?=null

    constructor(username:String,name:String,email:String,password:String)
    {
        this.name = name
        this.email = email
        this.username= username
        this.password = password
    }
}
