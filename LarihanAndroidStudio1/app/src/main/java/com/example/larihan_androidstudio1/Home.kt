package com.example.larihan_androidstudio1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        replaceFragment(FragmentWhite())
        val buttonWhite: Button = findViewById(R.id.buttonWhiteFragment)
        val buttonDark: Button = findViewById(R.id.buttonDarkFragment)

        val buttonLogoutSplash: Button = findViewById(R.id.buttonLogoutSplash)
        val buttonImplisitSplash: Button = findViewById(R.id.buttonImplisitSplash)

        buttonWhite.setOnClickListener {
            Log.d("Fragment", "Button White Clicked")
            replaceFragment(FragmentWhite())
        }

        buttonDark.setOnClickListener {
            Log.d("Fragment", "Button Dark Clicked")
            replaceFragment(FragmentDark())
        }

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

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}