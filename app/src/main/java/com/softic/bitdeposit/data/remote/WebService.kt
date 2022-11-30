package com.softic.bitdeposit.data.remote



import com.softic.bitdeposit.services.TransactionCreateRequest
import com.softic.bitdeposit.services.TransactionHistoryResponse
import com.softic.bitdeposit.services.TransactionMethodsResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface WebService {

    @GET("/api/v1/transactions")
     fun getTransactionList(): Call<TransactionHistoryResponse>
     @DELETE("/api/v1/transactions/{id}")
    suspend fun deleteItem(@Path("id") itemId: String): Response<ResponseBody>
    @GET("/api/v1/transactions/transaction-methods")
    fun getTransactionMethods(): Call<TransactionMethodsResponse>
    @POST("/api/v1/transactions")
     fun createTransaction(@Body body: TransactionCreateRequest):Call<TransactionHistoryResponse>

}