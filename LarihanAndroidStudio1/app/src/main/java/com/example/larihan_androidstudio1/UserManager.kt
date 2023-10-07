package com.example.larihan_androidstudio1

object UserManager {
    private val userMap: HashMap<String, String> = HashMap()

    fun registerUser(name: String, gender: String, email: String, password: String): Boolean {
        // Lakukan validasi data di sini sesuai kebutuhan Anda

        if (userMap.containsKey(email)) {
            // Jika email sudah terdaftar, kembalikan false
            return false
        }

        userMap[email] = password
        return true
    }

    fun loginUser(email: String, password: String): Boolean {
        val savedPassword = userMap[email]
        return savedPassword == password
    }
}