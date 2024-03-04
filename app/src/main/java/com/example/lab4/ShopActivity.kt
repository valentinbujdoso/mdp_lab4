package com.example.lab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.lab4.databinding.ActivityMainBinding
import com.example.lab4.databinding.ActivityShopBinding

private lateinit var binding: ActivityShopBinding
class ShopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intt = intent // Similar to  Intent intent = getIntent()
        val name = intt.getStringExtra("name")
        binding.welcomeText.text = "Welcome $name"

    }

    fun onToy(view: View){
        var tst = Toast.makeText(applicationContext,"You clicked on Toys and games!", Toast.LENGTH_LONG);
        tst.show()
    }

    fun onPet(view: View){
        var tst = Toast.makeText(applicationContext,"You clicked on Pet supplies!", Toast.LENGTH_LONG);
        tst.show()
    }

    fun onBeauty(view: View){
        var tst = Toast.makeText(applicationContext,"You clicked on Beauty and personal care!", Toast.LENGTH_LONG);
        tst.show()
    }

    fun onHome(view: View){
        var tst = Toast.makeText(applicationContext,"You clicked on Home and kitchen!", Toast.LENGTH_LONG);
        tst.show()
    }
}