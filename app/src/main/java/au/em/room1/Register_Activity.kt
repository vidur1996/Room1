package au.em.room1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import au.em.room1.database.Login
import au.em.room1.database.LoginDataBase
import au.em.room1.database.UserRegister
import au.em.room1.databinding.ActivityRegisterBinding
import kotlinx.coroutines.launch

class Register_Activity : BaseActivity(){

    private lateinit var binding: ActivityRegisterBinding
    var data = ArrayList<UserRegister>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.buttonRegister.setOnClickListener {


                writedata()
            var intent2 = Intent(this,MainActivity::class.java)
            Handler().postDelayed({
                setResult(RESULT_OK).also {startActivity(intent2)
                    finish() }
            },2000)

            startActivity(intent2)
        }
    }

    fun writedata(){
       var name =  binding.editTextName.text.toString()
        var email = binding.editTextEmailAddress.text.toString()
       var username =  binding.regEditTextUsername.text.toString()
        var password  =binding.editTextPassword1.text.toString()
       launch {
           val login =Login(username,name,email,password)
           applicationContext?.let {
               LoginDataBase(it).getLoginDao().insertAll(login)
               Toast.makeText(it,"saved success",Toast.LENGTH_LONG).show()
               binding.buttonRegister.text = "please login"


           }

       }



        }





    }
