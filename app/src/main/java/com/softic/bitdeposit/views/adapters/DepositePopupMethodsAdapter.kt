package com.softic.bitdeposit.views.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.softic.bitdeposit.interfaces.onDataTableItemClickAction
import com.softic.bitdeposit.interfaces.onMethodsItemClickAction
import com.softic.bitdeposit.services.*
import com.softic.bitdeposit.views.dialogs.CreateTransactionPopupDialog
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_deposit_methods.view.*
import kotlinx.android.synthetic.main.item_deposit_methods_.view.*
import kotlinx.android.synthetic.main.item_help_fag.*
import kotlinx.android.synthetic.main.item_help_fag.view.*


class DepositePopupMethodsAdapter(private val onItemClickAction: onMethodsItemClickAction) : RecyclerView.Adapter<DepositePopupMethodsAdapter.ViewHolder>() {
    var modelList = ArrayList<TransactionMethodsTypes>()
    lateinit var mContex:Context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {
        override val containerView: View
        get() = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContex = parent.context
        val view: View = LayoutInflater.from(parent.context).inflate(com.softic.bitdeposit.R.layout.item_deposit_methods_, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item : TransactionMethodsTypes = modelList.get(position)
        holder.containerView.transactionTypes.text = item.name
        holder.itemView.setOnClickListener {
            onItemClickAction.onMethodClick(position)
        }
    }

    override fun getItemCount(): Int {
        return modelList.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newProfileList : List<TransactionMethodsTypes>){
        modelList.clear()
        modelList.addAll(newProfileList)
        notifyDataSetChanged()
    }

}