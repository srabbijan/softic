package com.softic.bitdeposit.services

import com.google.gson.annotations.SerializedName

class TransactionCreateRequest (
    @SerializedName("tranRefId"                ) var tranRefId                : String?   = null,
    @SerializedName("tranType"                 ) var tranType                 : String?   = null,
    @SerializedName("tranStatus"               ) var tranStatus               : String?   = null,
    @SerializedName("amount"                   ) var amount                   : Int?      = null,
    @SerializedName("coin"                     ) var coin                     : Int?      = null,
    @SerializedName("metaData"                 ) var metaData                 : MetaData? = MetaData(),
    @SerializedName("createdById"              ) var createdById              : String?   = null,
    @SerializedName("userId"                   ) var userId                   : String?   = null,
    @SerializedName("betSiteUserAccountId"     ) var betSiteUserAccountId     : String?   = null,
    @SerializedName("transactionMethodId"      ) var transactionMethodId      : String?   = null,
    @SerializedName("transactionTypeId"        ) var transactionTypeId        : String?   = null,
    @SerializedName("transactionTypeAccountId" ) var transactionTypeAccountId : String?   = null,
    @SerializedName("userTransactionAccountId" ) var userTransactionAccountId : String?   = null,
    @SerializedName("senderId"                 ) var senderId                 : String?   = null,
    @SerializedName("receiverId"               ) var receiverId               : String?   = null
)