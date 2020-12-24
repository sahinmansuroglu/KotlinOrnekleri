package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun butonTiklama(view:View){

        var sayiListesiMetin:String=""
        val s1Text:EditText=findViewById(R.id.txtSayi1)
        val s2Text:EditText=findViewById(R.id.txtSayi2)
        val sonucText:TextView=findViewById(R.id.textViewSonuc)
        val sayiListText:TextView=findViewById(R.id.textViewSayiList)
        var tekCheckBox:CheckBox=findViewById(R.id.cbTek)
        var ciftCheckBox:CheckBox=findViewById(R.id.cbCift)
        var toplam=0
        var bas=(s1Text.text.toString()).toInt()
        var bitis=(s2Text.text.toString()).toInt()

        for (x in bas..bitis){
            if (ciftCheckBox.isChecked) {
                if (x%2==0) {
                    toplam = toplam + x
                    sayiListesiMetin = "${sayiListesiMetin} ${x} "
                }
            }

            if(tekCheckBox.isChecked){
                if (x%2==1) {
                    toplam = toplam + x
                    sayiListesiMetin = "${sayiListesiMetin} ${x} "
                }

            }
        }
        var tekCiftMetin=""

        if(tekCheckBox.isChecked and ciftCheckBox.isChecked)
            tekCiftMetin="Tüm"
        else if(tekCheckBox.isChecked)
            tekCiftMetin="Tek"
        else
            tekCiftMetin="Çift"

        if (!tekCheckBox.isChecked and !ciftCheckBox.isChecked){
            sonucText.text="Lütfen Tek veya Çift Kutularını seçin";
            sayiListText.text="Sayilar: Boş"
        }else{
            Log.d("Mesaj","${bas} ile ${bitis} arasındaki ${tekCiftMetin} sayıların toplamı=${toplam}")
            sonucText.text="${bas} ile ${bitis} arasındaki ${tekCiftMetin} sayıların toplamı=${toplam}";
            sayiListText.text="Sayilar: ${sayiListesiMetin}"
        }


    }
}
