package com.softic.bitdeposit.utils

import android.app.Dialog
import android.content.Context
import android.view.Window
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.Wave
import com.softic.bitdeposit.R
import kotlinx.android.synthetic.main.item_dialuge_beef.*

object CommonTask {
    fun animation(context: Context): Dialog {
        val dialog = Dialog(context, R.style.CommonDialog2)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.item_dialuge_beef)
        val doubleBounce: Sprite = Wave()
        dialog.spin_kit.setIndeterminateDrawable(doubleBounce)
        return dialog
    }
}