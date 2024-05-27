package com.luminoir.validwordfinderwithbacktracking

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel

class AlgorithmViewModel (application: Application): AndroidViewModel(application){
    private val kamus: Set<String> by lazy {
        loadKamus()
    }

    var alfabet by mutableStateOf("")
    var hasil by mutableStateOf(emptyList<Pair<String, Int>>())

    fun cariKata() {
        val alfabetList = alfabet.toList()
        val found = cariKataValid(alfabetList, kamus)
        hasil = found.map { kata -> kata to kata.length }
    }
    private fun loadKamus(): Set<String> {
        val kamusSet = mutableSetOf<String>()
        try {
            val inputStream = getApplication<Application>().assets.open("kamus.txt")
            inputStream.bufferedReader().useLines { lines ->
                lines.forEach { line ->
                    kamusSet.add(line.trim().toLowerCase())
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


    private fun AlgoritmaBacktrack(
        alfabet: MutableList<Char?>,
        path: MutableList<Char>,
        kamus: Set<String>,
        hasil: MutableSet<String>
    ){
        val kata = path.joinToString("")
        if (apakahValid(kata, kamus)) {
            hasil.add(kata)
        }

        if (path.size  == alfabet.size) return

        for (i in alfabet.indices){
            val char = alfabet[i]?: continue
            alfabet[i]=null
            path.add(char)

            AlgoritmaBacktrack(alfabet, path, kamus, hasil)

            path.removeAt(path.size - 1)
            alfabet[i] = char
        }
    }

    private fun cariKataValid(alfabet: List<Char>, kamus: Set<String>): Set<String>{
        val hasil = mutableSetOf<String>()
        AlgoritmaBacktrack(alfabet.toMutableList(), mutableListOf(), kamus, hasil)
        return hasil
    }
}