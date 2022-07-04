package com.udacity.shoestore.ui.shoes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesViewModel : ViewModel() {
    private val _shoesList = MutableLiveData<List<Shoe>>()

    val shoesList: LiveData<List<Shoe>>
        get() = _shoesList

    fun addShoe(shoeName: String, company: String, size: String, description: String) {
        val shoe = Shoe(shoeName, size.toDouble(), company, description, emptyList())
        val list = _shoesList.value?.toMutableList() ?: mutableListOf()
        list.add(shoe)
        _shoesList.value = list
    }
}