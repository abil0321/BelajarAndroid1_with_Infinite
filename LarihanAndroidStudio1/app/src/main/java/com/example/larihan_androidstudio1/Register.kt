package com.example.larihan_androidstudio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.larihan_androidstudio1.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val userMap: HashMap<String, String> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val btnRegister = findViewById<Button>(R.id.buttonRegis)

        binding.loginText.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        binding.buttonRegis.setOnClickListener {
            val name = binding.name.text.toString()
            val gender = binding.gender.text.toString()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val confirmPassword = binding.cpassword.text.toString()

            if (password == confirmPassword) {
                val isRegistered = UserManager.registerUser(name, gender, email, password)
                if (isRegistered) {
                    // Pindah ke halaman login
                    val intent = Intent(this, Login::class.java)
                    startActivity(intent)
                } else {
                    // Tampilkan pesan kesalahan jika email sudah terdaftar
                    // Anda dapat menambahkan TextView untuk menampilkan pesan kesalahan di XML layout Anda
                }
            } else {
                // Tampilkan pesan kesalahan jika kata sandi tidak cocok
                // Anda dapat menambahkan TextView untuk menampilkan pesan kesalahan di XML layout Anda
            }
        }
    }
}