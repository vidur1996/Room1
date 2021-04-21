package au.em.room1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import au.em.room1.database.Login
import au.em.room1.database.LoginDataBase
import au.em.room1.database.LoginDataBase_Impl
import au.em.room1.databinding.ActivityCoreBinding
import kotlinx.coroutines.launch

class Core_Activity  : BaseActivity(){

    var username:String = ""

    private lateinit var binding: ActivityCoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityCoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var intent = getIntent()

        username = intent.getStringExtra("username")
        binding.textViewUsername.text=username
        displayDetails()

        binding.buttonExit.setOnClickListener(){
           var intent1 =Intent(this, MainActivity::class.java)
            startActivity(intent1)
        }
    }

    fun displayDetails()
    {
        launch {
            applicationContext?.let {
            // list.add(Login())
               val list2=( LoginDataBase(it).getLoginDao().loadEmail(username))

                binding.emailText.text = list2[0].email.toString()
                binding.nameText.text = list2[0].name.toString()
            }
        }
    }
}