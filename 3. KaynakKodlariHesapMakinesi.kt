package com.example.gridlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var deger:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    fun rakamaTiklama(view:View){
        val sayiButon:Button=findViewById(view.id)
        val simdikiSayi:TextView=findViewById(R.id.simdikiSayiTxt)
        if (simdikiSayi.text.length==12){
            Toast.makeText(this, "En fazla 12 Rakam Girebilirsiniz", Toast.LENGTH_SHORT).show()

        }else{
            simdikiSayi.text=simdikiSayi.text.toString()+sayiButon.text.toString()

        }
    }

    fun islemYap(sayi1:Int,sayi2:Int,islem:String):Int{
        var sonuc:Int=0
        when (islem){
            "+"->{
                sonuc=sayi1+sayi2
            }
            "-"->{
                sonuc=sayi1-sayi2
            }
            "/"->{
                sonuc=sayi1/sayi2
            }
            "x"->{
                sonuc=sayi1*sayi2
            }
        }
        return  sonuc

    }
    fun islemeTiklama(view: View){
        val seciliIslem:Button=findViewById(view.id)
        val simdikiSayi:TextView=findViewById(R.id.simdikiSayiTxt)
        val eskiSayi:TextView=findViewById(R.id.eskiSayiTxt)
        val islemTextView:TextView=findViewById(R.id.islemTxt)

        if (eskiSayi.text.toString()!="" && simdikiSayi.text.toString()!=""){
            // Eski Sayı ve şimdiki sayı kutusunda sayı varsa burası çalışır
            //Tiklanan isleme Göre hesaplama yaptırılır
            var sayi1:Int=(eskiSayi.text.toString()).toInt()
            var sayi2:Int=(simdikiSayi.text.toString()).toInt()
            var islem:String=islemTextView.text.toString()
            eskiSayi.text=islemYap(sayi1,sayi2,islem).toString()
            simdikiSayi.text=""
            islemTextView.text=seciliIslem.text.toString()

        }else if(simdikiSayi.text.toString()!=""){
            // eskiSayi kutusu boş ve yeniSayı kutusunda sayı varsa burası çalışır
            islemTextView.text=seciliIslem.text.toString()
            eskiSayi.text=simdikiSayi.text.toString()
            simdikiSayi.text=""
        }else{
            //hem eski sayı kutusu hemde şimdiki sayı kutusu Boş sa burası çalışır
            Toast.makeText(this, "İşlem Yaptırılacak sayı Bulunamadı", Toast.LENGTH_SHORT).show()

        }
        Log.d("mesaj",seciliIslem.text.toString())
    }
    fun clearTiklama(view: View){
        val simdikiSayi:TextView=findViewById(R.id.simdikiSayiTxt)
        val eskiSayi:TextView=findViewById(R.id.eskiSayiTxt)
        val islem:TextView=findViewById(R.id.islemTxt)

        simdikiSayi.text=""
        eskiSayi.text=""
        islem.text=""

    }

    fun esittireTiklama(view: View){
        val seciliIslem:Button=findViewById(view.id)
        val simdikiSayi:TextView=findViewById(R.id.simdikiSayiTxt)
        val eskiSayi:TextView=findViewById(R.id.eskiSayiTxt)
        val islemTextView:TextView=findViewById(R.id.islemTxt)

        if (simdikiSayi.text.toString()=="" || eskiSayi.text.toString()==""){
            Toast.makeText(this, "Hesap Yaptırılacak Sayılar Bulunamadı", Toast.LENGTH_SHORT).show()

        }else{
            var sayi1:Int=(eskiSayi.text.toString()).toInt()
            var sayi2:Int=(simdikiSayi.text.toString()).toInt()
            var islem:String=islemTextView.text.toString()
            simdikiSayi.text=islemYap(sayi1,sayi2,islem).toString()
            eskiSayi.text=""
            islemTextView.text=""

        }

    }





}


