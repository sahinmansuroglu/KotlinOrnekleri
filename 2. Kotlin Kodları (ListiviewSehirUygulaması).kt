package com.example.sehiruygulamas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    val arrayList=ArrayList<String>()
    private lateinit var listView:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        arrayList.add("Adana")
        arrayList.add("Mersin")
        arrayList.add("Ankara")
        arrayList.add("İzmir")
        listView=findViewById(R.id.listViewNesne)
        val seciliSehirTextView=findViewById<TextView>(R.id.textViewSeciliSehir)
        val adapter=ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,arrayList)
        listView.adapter=adapter

        listView.setOnItemClickListener { parent, view, position, id ->
                val seciliSehir=parent.getItemAtPosition(position) as String
                seciliSehirTextView.text=seciliSehir.toString()

        }


    }

    fun sehirTekrarTesti(girilenSehirAdi:String):Boolean{
            if (arrayList.filter { s->s==girilenSehirAdi }.size==0) {
                return true
            }else{
                return false
            }
    }


    fun ekleButonClick(view: View){

        val sedirAdiEditText=findViewById<EditText>(R.id.editTextSehirAdi)
        var sehirAdi=sedirAdiEditText.text.toString()
       if (sehirTekrarTesti(sehirAdi)) {
           arrayList.add(sehirAdi)

           for (sira in 0..(arrayList.size - 1))
               Log.d("mesaj:", "sehir Adi:" + arrayList.get(sira))
           Log.d("mesaj:", "Eleman Sayisi:" + arrayList.size)
           Log.d("mesaj:", sehirAdi)
           listView.deferNotifyDataSetChanged()
       }else{
            Toast.makeText(this,"${sehirAdi} adlı şehir zaten Listeye Ekli!",Toast.LENGTH_LONG).show()

       }
    }
}
