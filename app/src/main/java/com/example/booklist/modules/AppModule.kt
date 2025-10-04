package com.example.booklist.modules

import com.example.booklist.providers.StorageServiceProvider
import org.koin.core.module.dsl.singleOf
import com.example.booklist.providers.StorageServiceProviderImpl
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.core.module.dsl.bind
import com.example.booklist.ui.theme.viewModel.BooksViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val appModule = module {
    single<FirebaseFirestore> { FirebaseFirestore.getInstance() }
    singleOf(::StorageServiceProviderImpl) { bind<StorageServiceProvider>() }
    viewModelOf(::BooksViewModel)
}