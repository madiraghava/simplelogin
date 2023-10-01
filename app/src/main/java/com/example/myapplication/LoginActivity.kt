package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.google.android.material.snackbar.Snackbar
import android.content.Intent

class LoginActivity : ComponentActivity() {


    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonSubmit: Button

    private val validUsernamesAndPasswords = listOf(
        "user1" to "password1",
        "user2" to "password2",
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextUsername = findViewById(R.id.usernameField)
        editTextPassword = findViewById(R.id.passwordField)
        buttonSubmit = findViewById(R.id.loginButton)

        buttonSubmit.setOnClickListener {

            val enteredUsername = editTextUsername.text.toString()
            val enteredPassword = editTextPassword.text.toString()

            if (enteredUsername.isNotEmpty() && enteredPassword.isNotEmpty()) {
                val isValidPair = validUsernamesAndPasswords.any { (username, password) ->
                    username == enteredUsername && password == enteredPassword
                }
                if (isValidPair) {
                    Toast.makeText(this@LoginActivity, "Login success.", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@LoginActivity, "Login failed.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@LoginActivity, "Please enter a username and password.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}