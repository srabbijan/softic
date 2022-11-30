package com.softic.bitdeposit.views.dialogs


import android.app.Dialog
import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.softic.bitdeposit.R
import com.softic.bitdeposit.data.remote.APIHelper
import com.softic.bitdeposit.data.remote.WebService
import com.softic.bitdeposit.services.MetaData
import com.softic.bitdeposit.services.TransactionCreateRequest
import com.softic.bitdeposit.services.TransactionHistoryResponse
import com.softic.bitdeposit.services.TransactionMethodsResponse
import com.softic.bitdeposit.utils.gone
import com.softic.bitdeposit.utils.show
import kotlinx.android.synthetic.main.create_transaction_dialogs.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateTransactionPopupDialog() : BottomSheetDialogFragment() {
    private lateinit var mContext: Context
    lateinit var webService: WebService
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        webService = APIHelper.getInstance().create(WebService::class.java)
        return inflater.inflate(R.layout.create_transaction_dialogs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        cancel_sheet.setOnClickListener {
            onDestroyView()
        }
        back_sheet.setOnClickListener {
            onDestroyView()
        }
        cancel.setOnClickListener {
            onDestroyView()
        }
        selectFile.setOnClickListener {
            beforeImageSelect.gone()
            afterImageSelect.show()
        }
        selectedFileRemove.setOnClickListener {
            beforeImageSelect.show()
            afterImageSelect.gone()
        }
        submit.setOnClickListener {
           createNewTransaction()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
    fun createNewTransaction(){
        val commitDnCRequest = TransactionCreateRequest(
            trasaction_number.text.toString(),
            "TRANSFER",
            "PENDING",
            deposite_number.text.toString().toInt(),
            0,
            metaData = MetaData(),
            "3fa85f64-5717-4562-b3fc-2c963f66afa6",
            "3fa85f64-5717-4562-b3fc-2c963f66afa6",
            "3fa85f64-5717-4562-b3fc-2c963f66afa6",
            "3fa85f64-5717-4562-b3fc-2c963f66afa6",
            "3fa85f64-5717-4562-b3fc-2c963f66afa6",
            "3fa85f64-5717-4562-b3fc-2c963f66afa6",
            "3fa85f64-5717-4562-b3fc-2c963f66afa6",
            "3fa85f64-5717-4562-b3fc-2c963f66afa6",
            "3fa85f64-5717-4562-b3fc-2c963f66afa6"
        )
        webService.createTransaction(commitDnCRequest).enqueue(object : Callback<TransactionHistoryResponse> {
            override fun onResponse(call: Call<TransactionHistoryResponse>, response: Response<TransactionHistoryResponse>) {
                if (response.isSuccessful) {
                    val shop: TransactionHistoryResponse? = response.body()
                    if (shop != null) {
                        val depositPopupDialog = TransactionsSuccessDialog()
                        depositPopupDialog.show(childFragmentManager, "createDialogFrag")
                    }
                }
            }
            override fun onFailure(call: Call<TransactionHistoryResponse>, t: Throwable) {
                Log.d("TAG", "onResponse: $call")
                Log.d("TAG", "onResponse: $t")
            }

        })
    }
}