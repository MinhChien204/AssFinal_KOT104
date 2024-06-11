package com.quynhlm.dev.furnitureapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quynhlm.dev.furnitureapp.models.Product
import com.quynhlm.dev.furnitureapp.service.RetrofitService
import kotlinx.coroutines.launch

class ProductViewModel:ViewModel() {
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products
    init {
        getProducts()
    }
    private  fun getProducts() {
        viewModelScope.launch {
            try {
                val response = RetrofitService().productService.getListProduct()
                Log.d("TAG", "getMovies: $response ")

                if (response.isSuccessful) {

                    _products.postValue(response.body()?.map { it.toMovie() }) // map de chuyen response jsonarray thanh List<Movie>
                } else {
                    _products.postValue(emptyList())
                }
            } catch (e: Exception) {
                Log.e("TAG", "getMovies: " + e.message)
                _products.postValue(emptyList())
            }
        }
    }
    fun getMovieById(filmId: String?): LiveData<Product?> {
        val liveData = MutableLiveData<Product?>()
        filmId?.let {
            viewModelScope.launch {
                try {
                    val response = RetrofitService().productService.getProductDetail(filmId)
                    if (response.isSuccessful) {
                        liveData.postValue(response.body()?.toMovie())
                    } else {
                        liveData.postValue(null)
                    }
                } catch (e: Exception) {
                    liveData.postValue(null)
                }
            }
        }
        return liveData
    }
}