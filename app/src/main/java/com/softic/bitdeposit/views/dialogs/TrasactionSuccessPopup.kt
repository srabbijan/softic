package com.softic.bitdeposit.views.dialogs


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.LinearLayoutCompat
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.softic.bitdeposit.R
import com.softic.bitdeposit.databinding.ActivityMainBinding
import com.softic.bitdeposit.services.Data
import kotlinx.android.synthetic.main.transaction_details_dialogs.*

class TrasactionSuccessPopup() : BottomSheetDialogFragment() {
    private lateinit var mContext: Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.transaction_success_dialogs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cancel_sheet.setOnClickListener {
            onDestroyView()
        }

        PendingTime.text = "-"
        Remark.text = "-"

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}