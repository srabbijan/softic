package com.softic.bitdeposit.views.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.softic.bitdeposit.R
import com.softic.bitdeposit.interfaces.onDataTableItemClickAction
import com.softic.bitdeposit.interfaces.onDepositPopupInf
import com.softic.bitdeposit.interfaces.onMethodsItemClickAction
import com.softic.bitdeposit.services.Data
import com.softic.bitdeposit.services.Methods
import com.softic.bitdeposit.services.TransactionHistoryResponse
import com.softic.bitdeposit.services.TransactionMethodsResponse
import com.softic.bitdeposit.utils.gone
import com.softic.bitdeposit.utils.show
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_deposit_methods.view.*
import kotlinx.android.synthetic.main.item_help_fag.*
import kotlinx.android.synthetic.main.item_help_fag.view.*

class DepositePopupAdapter(private val clickAction: onDepositPopupInf):
    RecyclerView.Adapter<DepositePopupAdapter.ViewHolder>(),    onMethodsItemClickAction{
    var modelList = ArrayList<Methods>()
    lateinit var mContex:Context
    lateinit var helpAndFaqAdapter: DepositePopupMethodsAdapter

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {
        override val containerView: View
        get() = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContex = parent.context
        helpAndFaqAdapter = DepositePopupMethodsAdapter(this)
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_deposit_methods, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item : Methods = modelList.get(position)
        holder.containerView.name.text = item.name

        val helpAndFaq = holder.containerView.help_faq_linear
        helpAndFaq.adapter = helpAndFaqAdapter
        helpAndFaqAdapter.updateList(item.transactionTypes)

    }

    override fun getItemCount(): Int {
        return modelList.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newProfileList : List<Methods>){
        modelList.clear()
        modelList.addAll(newProfileList)
        notifyDataSetChanged()
    }

    override fun onMethodClick(data: Int) {
        clickAction.onItemClick(data)
    }

}