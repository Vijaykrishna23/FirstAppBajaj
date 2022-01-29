package com.example.helloworld

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class HomeActivity : AppCompatActivity(), View.OnFocusChangeListener {

    lateinit var tvHome: TextView
    lateinit var etContact: EditText
    lateinit var etEmail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var tvHome = findViewById<TextView>(R.id.tvHome)
        var name = intent.extras?.getString("vk")
        tvHome.text = name

        etContact = findViewById(R.id.etContact)
        etEmail = findViewById(R.id.etEmail)


        etContact.setOnFocusChangeListener(this)


    }

    override fun onPause() {
        super.onPause()
        storeState();
    }

    //view-tool windows-file exploreer-data/data/yourpackage/sharedprefs/filename
    private fun storeState() {

        var contact: String = etContact.text.toString()
        var email = etEmail.text.toString()

        var sharedPreferences = getSharedPreferences("home_state_prefs", MODE_PRIVATE)

        var editor = sharedPreferences.edit()

        editor.putString("cont",contact)
        editor.putString("eml",email)

        editor.apply() //appply is asynchronous
    }


    override fun onResume() {
        super.onResume()
        restoreState();
    }

    private fun restoreState() {

        var sharedPreferences = getSharedPreferences("home_state_prefs", MODE_PRIVATE)

        var contact = sharedPreferences.getString("cont","")
        var email = sharedPreferences.getString("eml","")

        etContact.setText(contact)
        etEmail.setText(email)
    }

    fun handleClick(view: android.view.View) {
        when (view.id) {
            R.id.btnSend -> {
                startDialer()
            }
            R.id.btnMain -> {
                startMain()
            }
        }
    }

    private fun startDialer() {
        var dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:21345678"))
        startActivity(dialIntent)
    }

    private fun startMain() {
        var intent = Intent(this, MainActivity::class.java)
        intent.putExtra("kv", "krishna vijay")
        startActivityForResult(intent, 123)
    }


    //result will arrive here -- photo, contact
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == 123) { //RESULT_OK means its good to consume, 123 -- data being returned is of type contact
            tvHome.text = data?.extras?.getString("con")
        }
    }

    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        if (hasFocus) {
            Toast.makeText(this, "focussed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "lost focus", Toast.LENGTH_SHORT).show()

        }
    }
}