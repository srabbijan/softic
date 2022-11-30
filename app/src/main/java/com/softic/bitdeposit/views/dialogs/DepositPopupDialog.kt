package com.softic.bitdeposit.views.dialogs


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.softic.bitdeposit.R
import com.softic.bitdeposit.databinding.ActivityMainBinding
import com.softic.bitdeposit.interfaces.onDepositPopupInf
import com.softic.bitdeposit.services.Data
import com.softic.bitdeposit.services.TransactionMethodsResponse
import com.softic.bitdeposit.views.adapters.DepositePopupAdapter
import com.softic.bitdeposit.views.adapters.TransactionAdapter
import kotlinx.android.synthetic.main.transaction_details_dialogs.*

class DepositPopupDialog(private val data: TransactionMethodsResponse) : BottomSheetDialogFragment() ,onDepositPopupInf{
    private lateinit var mContext: Context
    lateinit var helpAndFaqAdapter: DepositePopupAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.deposit_popup_dialogs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        helpAndFaqAdapter = DepositePopupAdapter(this)
        val helpAndFaq = view.findViewById<RecyclerView>(R.id.help_faq_linear)
        helpAndFaq.layoutManager = LinearLayoutManager(mContext)
        helpAndFaq.adapter = helpAndFaqAdapter
        helpAndFaqAdapter.updateList(data.Methods)

        cancel_sheet.setOnClickListener {
            onDestroyView()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onItemClick(data: Int) {
        Log.e("onItemClick", "onItemClick: ${data}", )
        val depositPopupDialog = CreateTransactionPopupDialog()
        depositPopupDialog.show(childFragmentManager, "createDialogFrag")
    }
}