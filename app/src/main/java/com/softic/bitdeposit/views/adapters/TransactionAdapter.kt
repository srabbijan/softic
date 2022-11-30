package com.softic.bitdeposit.views.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.softic.bitdeposit.R
import com.softic.bitdeposit.interfaces.onDataTableItemClickAction
import com.softic.bitdeposit.services.Data
import com.softic.bitdeposit.services.TransactionHistoryResponse
import com.softic.bitdeposit.utils.gone
import com.softic.bitdeposit.utils.show
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_help_fag.*
import kotlinx.android.synthetic.main.item_help_fag.view.*

class TransactionAdapter(private val onItemClickAction: onDataTableItemClickAction)
    : RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {
    var modelList = ArrayList<Data>()
   lateinit var selectedView:View
    lateinit var mContex:Context
    var oldPosition :Int =-1
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {
        override val containerView: View
        get() = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContex = parent.context
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_help_fag, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item : Data = modelList.get(position)
        holder.containerView.sl_no.text = "${position+1}"
        holder.containerView.tranType.text = item.tranType
        holder.containerView.transactionMethod.text = item.transactionMethod?.name
        holder.containerView.amount.text = item.amount.toString()
        holder.containerView.transactionType.text = item.transactionType?.name
        holder.containerView.tranId.text = item.tranId
        holder.containerView.userId.text = item.userId

        holder.containerView.tranId_.text = item.tranId
        holder.containerView.createdAt.text = item.createdAt
        holder.containerView.coin.text = item.coin.toString()
        holder.containerView.statusChangedAt.text = item.statusChangedAt
        holder.containerView.tranStatus.text = item.tranStatus

        if("APPROVED".equals(item.tranStatus)){
            holder.containerView.remark.show()
            holder.containerView.delete.gone()
        }
        else{
            holder.containerView.remark.gone()
            holder.containerView.delete.show()
        }
        holder.containerView.show.setOnClickListener {
            onItemClickAction.onViewClick(item)
//            Toast.makeText(mContex, "View", Toast.LENGTH_SHORT).show()
        }
        holder.containerView.delete.setOnClickListener {
//            Toast.makeText(mContex, "delete", Toast.LENGTH_SHORT).show()
            onItemClickAction.onItemDeleteClick(item)
        }

        holder.itemView.setOnClickListener {

            if (::selectedView.isInitialized){
                if (position==oldPosition){
                    selectedView.transition_layout_save.visibility=if(selectedView.transition_layout_save.visibility == View.VISIBLE) View.GONE else View.VISIBLE
                    selectedView.expand_activities_button.setImageDrawable(ContextCompat.getDrawable(mContex, R.drawable.dropdown))
                    oldPosition=-1
                }
                else{
                    selectedView.expand_activities_button.setImageDrawable(ContextCompat.getDrawable(mContex, R.drawable.dropdown))
                    selectedView.transition_layout_save.gone()

                    holder.containerView.transition_layout_save?.show()
                    holder.containerView.expand_activities_button?.setImageDrawable(ContextCompat.getDrawable(mContex, R.drawable.dropup))
                    oldPosition = position
                }

            }else{
                holder.containerView.transition_layout_save?.show()
                holder.containerView.expand_activities_button?.setImageDrawable(ContextCompat.getDrawable(mContex, R.drawable.dropup))
            }
            selectedView = holder.itemView


        }
    }

    override fun getItemCount(): Int {
        return modelList.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newProfileList : List<Data>){
        modelList.clear()
        modelList.addAll(newProfileList)
        notifyDataSetChanged()
    }

}