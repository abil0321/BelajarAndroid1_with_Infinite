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
        val buttonImplisitSplash: Button = findViewById(R.id.buttonImplisitSplash)

        buttonImplisitSplash.setOnClickListener {
            performShare()
        }

        buttonLogoutSplash.setOnClickListener {
            performLogout()
        }
    }

    private fun performShare(){
        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.type = "text/plain"
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("tujuan@example.com"))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subjek Email")
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Isi pesan email")

        // Coba mulai aktivitas yang sesuai dengan intent
        try {
            startActivity(Intent.createChooser(emailIntent, "Kirim Email"))
        } catch (ex: android.content.ActivityNotFoundException) {
            // Handle jika tidak ada aplikasi email yang tersedia
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