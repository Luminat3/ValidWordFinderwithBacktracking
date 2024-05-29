package com.luminoir.validwordfinderwithbacktracking

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import java.util.Locale
import kotlin.system.measureTimeMillis

class AlgorithmViewModel (application: Application): AndroidViewModel(application){
    private val kamus: Set<String> by lazy {
        loadKamus()
    }

    var alfabet by mutableStateOf("")
    var hasil by mutableStateOf(emptyList<Pair<String, Int>>()) //inisialisasi awal
    var searchTime by mutableStateOf(0L) //inisialisasi awal search time

    //untuk menglimit hasil pencarian maksimum
//    private val HASIL_MAX = 100

    fun cariKata() {
        val alfabetList = alfabet.toList()
        searchTime = measureTimeMillis {
            var found = cariKataValid(alfabetList, kamus)
            hasil = found.map { kata -> kata to kata.length }
//            hasil = found.take(HASIL_MAX).map { kata -> kata to kata.length }
        }
    }

    //membaca source kamus, dan menginisialisasinya ke sebuah variable
    private fun loadKamus(): Set<String> {
        val kamusSet = mutableSetOf<String>()
        try {
            val inputStream = getApplication<Application>().assets.open("kamus.txt")
            inputStream.bufferedReader().useLines { lines ->
                lines.forEach { line ->
                    kamusSet.add(line.trim().lowercase(Locale.getDefault()))
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return kamusSet
    }

    private fun apakahValid(kata: String, kamus: Set<String>):Boolean {
        return kata in kamus
    }


    private fun algoritmaBacktrack(
        alfabet: MutableList<Char?>,
        path: MutableList<Char>,
        kamus: Set<String>,
        hasil: MutableSet<String>,
        memo: MutableMap<String, Set<String>>
    ){
        val kata = path.joinToString("")
        if (kata in memo) {
            hasil.addAll(memo[kata]!!)
            return
        }

        if (apakahValid(kata, kamus)) {
            hasil.add(kata)                     //cek jika kata itu valid atau tidak menggunakan
        }                                       //fun apakahValid jika hasil True maka dimasukkan ke hasil
                                                // jika False maka tidak dimasukkan


        if (path.size  == alfabet.size) return  //kondisi berhenti eksplorasi, jika panjang path
                                                // itu sama dengan panjang yang diinput
        for (i in alfabet.indices){
            val char = alfabet[i]?: continue
            alfabet[i]=null
            path.add(char)

            algoritmaBacktrack(alfabet, path, kamus, hasil, memo) //Memanggil ulang fungsi backtracking (rekursif)
                                                                  //Ini dilakukan agar dapat mencoba semua rute yang ada
            path.removeAt(path.size - 1)
            alfabet[i] = char
        }
        memo[kata] = hasil.toSet()
    }

    fun deleteHasil() {
        hasil = emptyList()
        searchTime = 0L
    }
    private fun cariKataValid(alfabet: List<Char>, kamus: Set<String>): Set<String>{
        val hasil = mutableSetOf<String>()
        val memo = mutableMapOf<String, Set<String>>()
        algoritmaBacktrack(alfabet.toMutableList(), mutableListOf(), kamus, hasil, memo)
        return hasil
    }
}