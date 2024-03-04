package com.example.lab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.lab4.databinding.ActivityCreateAccountBinding
import com.example.lab4.databinding.ActivityMainBinding
import java.io.Serializable

private lateinit var binding: ActivityCreateAccountBinding
class CreateAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onRegister(view: View){
        val name = binding.nameTextEdit.text.toString()
        val pwd = binding.pwdTextEdit.text.toString()
        val repwd = binding.repwdTextEdit.text.toString()
        val email = binding.mobileOrEmailTextEdit.text.toString()

        if (name == "") {
            Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_LONG).show()
            return
        }

        if (pwd == "") {
            Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_LONG).show()
            return
        }

        if (repwd == "") {
            Toast.makeText(this, "Re-password cannot be empty", Toast.LENGTH_LONG).show()
            return
        }

        if (email == "") {
            Toast.makeText(this, "Email cannot be empty", Toast.LENGTH_LONG).show()
            return
        }

        if (!pwd.equals(repwd)) {
            Toast.makeText(this, "Password and Re-password should be the same", Toast.LENGTH_LONG).show()
            return
        }

        val temp = intent.getSerializableExtra("users")
        var result = temp as HashMap<*, *>

        if(result.contains(email)) {
            Toast.makeText(this, "Email already in use", Toast.LENGTH_LONG).show()
            return
        }

        val user = User(email, name, pwd)
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("user",  user as Serializable)
        Toast.makeText(this, "User created", Toast.LENGTH_LONG).show()
        startActivity(intent)
    }
}