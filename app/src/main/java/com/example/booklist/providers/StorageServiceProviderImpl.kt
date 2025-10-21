package com.example.booklist.providers

import com.example.booklist.model.BooksModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import com.google.firebase.firestore.toObject

class StorageServiceProviderImpl(private val firestore: FirebaseFirestore) :
    StorageServiceProvider {

    override suspend fun getListBooks(): List<BooksModel> =
        firestore.collection(COLLECTION_BOOKS).get().await().toObjects(BooksModel::class.java)

    override suspend fun getBook(idBook: String): BooksModel? =
        firestore.collection(COLLECTION_BOOKS).document(idBook).get().await().toObject()

    override suspend fun saveBooks(booksModel: BooksModel) {
        firestore.collection(COLLECTION_BOOKS).add(booksModel).await()
    }

    override suspend fun updateBooks(booksModel: BooksModel) {
        firestore.collection(COLLECTION_BOOKS).document(booksModel.index).set(booksModel).await()
    }

    override suspend fun deleteBooks(idBook: String) {
        firestore.collection(COLLECTION_BOOKS).document(idBook).delete().await() ?: Throwable()
    }

    companion object {
        const val COLLECTION_BOOKS = "books"
    }
}