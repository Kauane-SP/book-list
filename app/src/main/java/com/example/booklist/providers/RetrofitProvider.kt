package com.example.booklist.providers

interface RetrofitProvider {
    fun getInstanceRetrofitBooks(): ApiBooksProvider
}