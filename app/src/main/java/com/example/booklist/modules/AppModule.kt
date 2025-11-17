package com.example.booklist.modules

import com.example.booklist.providers.RequestApiBooksProvider
import com.example.booklist.providers.StorageServiceProvider
import org.koin.core.module.dsl.singleOf
import com.example.booklist.providers.StorageServiceProviderImpl
import com.example.booklist.providers.UserRegisterServiceProvider
import com.example.booklist.providers.UserRegisterServiceProviderImpl
import com.example.booklist.providers.RequestApiBooksProviderImpl
import com.example.booklist.providers.RetrofitBooksProviderImpl
import com.example.booklist.providers.RetrofitProvider
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.core.module.dsl.bind
import com.example.booklist.ui.theme.viewModel.BooksViewModel
import com.example.booklist.ui.theme.viewModel.GoogleBooksViewModel
import com.example.booklist.ui.theme.viewModel.UserAuthViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val appModule = module {
    single<FirebaseFirestore> { FirebaseFirestore.getInstance() }
    single { get<RetrofitProvider>().getInstanceRetrofitBooks() }
    singleOf(::StorageServiceProviderImpl) { bind<StorageServiceProvider>() }
    singleOf(::UserRegisterServiceProviderImpl) { bind<UserRegisterServiceProvider>() }
    singleOf(::RequestApiBooksProviderImpl) { bind<RequestApiBooksProvider>() }
    singleOf(::RetrofitBooksProviderImpl) { bind<RetrofitProvider>() }
    viewModelOf(::BooksViewModel)
    viewModelOf(::GoogleBooksViewModel)
    viewModelOf(::UserAuthViewModel)

}