package com.softic.bitdeposit.interfaces

import com.softic.bitdeposit.services.Data

interface onDataTableItemClickAction {
    fun onViewClick(data: Data)
    fun onItemDeleteClick(data: Data)

}