package com.example.booklist.providers

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBooksProviderImpl: RetrofitProvider {

    private fun getRetrofitInstance(url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override fun getInstanceRetrofitBooks(): ApiBooksProvider {
        return getRetrofitInstance("https://www.googleapis.com/books/v1/")
            .create(ApiBooksProvider::class.java)
    }
}