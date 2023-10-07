package com.example.larihan_androidstudio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.larihan_androidstudio1.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.registerText.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        binding.buttonLogin.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val errorMessage = findViewById<TextView>(R.id.errorMessage)

            val isLoggedIn = UserManager.loginUser(email, password)
            if (isLoggedIn) {
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
            } else {
                errorMessage.text = "Email atau kata sandi salah. Silakan coba lagi."
                errorMessage.visibility = View.VISIBLE
            }
        }

    }
}