package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class sayi2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sayi2)
        val gelensayi1:String=intent.getStringExtra("sayi1")

        val txtSayi1: EditText =findViewById(R.id.txtSayi1)
        txtSayi1.setText(gelensayi1.toString())
    }

    fun tiklandi (view: View){

        val yeniIntent=Intent(this@sayi2Activity,toplamActivity::class.java)
        val s1Text: EditText =findViewById(R.id.txtSayi1)
        val s2Text: EditText =findViewById(R.id.txtSayi2)
        yeniIntent.putExtra("sayi1",s1Text.text.toString())
        yeniIntent.putExtra("sayi2",s2Text.text.toString())
        startActivity(yeniIntent)
    }
}
