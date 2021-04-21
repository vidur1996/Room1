package au.em.room1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.findNavController
import au.em.room1.database.Login
import au.em.room1.database.LoginDataBase
import au.em.room1.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : BaseActivity(){
    private lateinit var binding: ActivityMainBinding
    var username:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        username = binding.editTextUsername.text.toString()

        binding.buttonNewUser.setOnClickListener {

            var intentReg = Intent(this,Register_Activity::class.java)
            startActivity(intentReg)
        }


            binding.buttonSignin.setOnClickListener {
                username = binding.editTextUsername.text.toString()
             checkPass()



            }
        }

    fun checkPass(){
        var  pass: String?= null
        launch {

            applicationContext?.let {
                pass = LoginDataBase(it).getLoginDao().checkPassword(username)
             binding.textView.text = pass


                if(pass== null)
                {
                    Toast.makeText(it,"invalis username",Toast.LENGTH_LONG).show()
                    binding.editTextPassword.setText("")
                    binding.editTextUsername.setText("")

                }
                else if(pass.equals(binding.editTextPassword.text.toString().trim())) {
                    Toast.makeText(it,"login successful",Toast.LENGTH_LONG).show()

                    var intentSignin = Intent(it,Core_Activity::class.java)
                    intentSignin.putExtra("username",username)
                    startActivity(intentSignin)


                }
                else{
                    Toast.makeText(it,"password invalid",Toast.LENGTH_LONG).show()
                    binding.editTextPassword.setText("")
                    binding.editTextUsername.setText("")

                }
            }
        }






    }


    }
