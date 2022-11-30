package com.softic.bitdeposit.views.activites

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.softic.bitdeposit.data.remote.WebService
import com.softic.bitdeposit.databinding.ActivityMainBinding
import com.softic.bitdeposit.data.remote.APIHelper
import com.softic.bitdeposit.interfaces.onDataTableItemClickAction
import com.softic.bitdeposit.services.Data
import com.softic.bitdeposit.services.TransactionHistoryResponse
import com.softic.bitdeposit.services.TransactionMethodsResponse
import com.softic.bitdeposit.utils.CommonTask
import com.softic.bitdeposit.views.adapters.DepositePopupMethodsAdapter
import com.softic.bitdeposit.views.adapters.TransactionAdapter
import com.softic.bitdeposit.views.dialogs.DepositPopupDialog
import com.softic.bitdeposit.views.dialogs.TransactionDetailsDialog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() , onDataTableItemClickAction{
    private lateinit var binding: ActivityMainBinding
    lateinit var webService: WebService
    lateinit var helpAndFaqAdapter: TransactionAdapter
    private lateinit var dialog: Dialog
    lateinit var modelList: MutableList<Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        helpAndFaqAdapter = TransactionAdapter(this)
        val helpAndFaq: RecyclerView = binding.helpFaqLinear
        helpAndFaq.layoutManager = LinearLayoutManager(this)
        helpAndFaq.adapter = helpAndFaqAdapter
        dialog = CommonTask.animation(this)
        binding.wrap.setOnClickListener {
            dialog.show()
            getMethods()
        }

        webService = APIHelper.getInstance().create(WebService::class.java)
         getData()
    }
    private fun getData(){
        dialog.show()
        webService.getTransactionList().enqueue(object : Callback<TransactionHistoryResponse> {
            override fun onResponse(call: Call<TransactionHistoryResponse>, response: Response<TransactionHistoryResponse>) {
                if (response.isSuccessful) {
                    dialog.dismiss()
                    val shop: TransactionHistoryResponse? = response.body()
                    if (shop != null) {
                        modelList = shop.data
//                        modelList.addAll(shop.data)
                        helpAndFaqAdapter.updateList(modelList)
                        Log.d("TAG", "onResponse: "+shop.data.size)
                    }
                }
            }

            override fun onFailure(call: Call<TransactionHistoryResponse>, t: Throwable) {
                dialog.dismiss()
                Log.d("TAG", "onResponse: $call")
                Log.d("TAG", "onResponse: $t")
            }

        })


    }
    private fun getMethods(){
        webService.getTransactionMethods().enqueue(object : Callback<TransactionMethodsResponse> {
            override fun onResponse(call: Call<TransactionMethodsResponse>, response: Response<TransactionMethodsResponse>) {
                if (response.isSuccessful) {
                    dialog.dismiss()
                    val shop: TransactionMethodsResponse? = response.body()
                    if (shop != null) {
                        val depositPopupDialog = DepositPopupDialog(shop)
                        depositPopupDialog.show(supportFragmentManager, "depositPopupDialog")
                        Log.d("TAG", "onResponse: "+shop.Methods.size)
                    }
                }
            }
            override fun onFailure(call: Call<TransactionMethodsResponse>, t: Throwable) {
                dialog.dismiss()
                Log.d("TAG", "onResponse: $call")
                Log.d("TAG", "onResponse: $t")
            }

        })


    }
    override fun onViewClick(data: Data) {
            val transactionDetailsDialog = TransactionDetailsDialog(data)
        transactionDetailsDialog.show(supportFragmentManager, "transactionDetailsDialog")

    }
    override fun onItemDeleteClick(data: Data) {
        val id : String = data.id
        dialog.show()
        CoroutineScope(Dispatchers.IO).launch {
            val response = webService.deleteItem(id)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    dialog.dismiss()
                    response.code()
                    if(response.code()==204){
                        modelList.remove(data)
                        helpAndFaqAdapter.updateList(modelList)
                    }
                    Log.d("Pretty Printed JSON :", response.code().toString())

                } else {
                    dialog.dismiss()
                    Log.e("RETROFIT_ERROR", response.code().toString())

                }
            }
    }
}

}