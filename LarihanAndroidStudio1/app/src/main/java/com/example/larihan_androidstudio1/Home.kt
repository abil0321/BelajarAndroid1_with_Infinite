package com.example.larihan_androidstudio1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val buttonLogoutSplash: Button = findViewById(R.id.buttonLogoutSplash)

        buttonLogoutSplash.setOnClickListener {
            // Panggil fungsi logout
            performLogout()
        }
    }

    private fun performLogout() {
        // Hapus data login sementara (misalnya, token autentikasi)
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.remove("authToken")
        editor.apply()

        // Navigasi kembali ke halaman login
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
        finish() // Tutup halaman saat ini agar tidak dapat kembali
    }
}