package com.example.lab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.lab4.databinding.ActivityMainBinding
import java.io.Serializable

private lateinit var binding: ActivityMainBinding

class User constructor(a: String, b: String, c: String) : Serializable {
    var email = a
    var name = b
    var pwd = c
}

class MainActivity : AppCompatActivity() {
    var users =
        HashMap<String, User>(mapOf("test@email.com" to User("test@email.com", "name", "test")))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (intent.getSerializableExtra("user") != null) {
            val temp = intent.getSerializableExtra("user")
            var result = temp as User

            users.put(result.email, result)
        }
    }

    fun onSignIn(view: View) {
        val email = binding.loginemailText.text.toString()
        val pwd = binding.loginpwdText.text.toString()

        if (users.containsKey(email) and users.get(email)?.pwd.equals(pwd)) {
            val intent = Intent(this, ShopActivity::class.java)
            intent.putExtra("name", users.get(email)?.name)
            startActivity(intent)
        } else {
            var tst = Toast.makeText(applicationContext, "Invalid credentials", Toast.LENGTH_LONG);
            tst.show()
        }
    }

    fun onCreate(view: View) {
        val intent = Intent(this, CreateAccountActivity::class.java)
        intent.putExtra("users",  users as Serializable)
        startActivity(intent)
    }
}