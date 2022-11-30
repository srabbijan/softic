package com.softic.bitdeposit.services

import com.google.gson.annotations.SerializedName

data class TransactionMethodsResponse(
    @SerializedName("status"  ) var status  : String?         = null,
    @SerializedName("data"    ) var Methods    : ArrayList<Methods> = arrayListOf(),
    @SerializedName("message" ) var message : String?         = null
)
data class Methods (

    @SerializedName("id"               ) var id               : String?           = null,
    @SerializedName("name"             ) var name             : String?           = null,
    @SerializedName("code"             ) var code             : String?           = null,
    @SerializedName("status"           ) var status           : String?           = null,
    @SerializedName("createdById"      ) var createdById      : String?           = null,
    @SerializedName("updatedById"      ) var updatedById      : String?           = null,
    @SerializedName("createdAt"        ) var createdAt        : String?           = null,
    @SerializedName("updatedAt"        ) var updatedAt        : String?           = null,
    @SerializedName("transactionTypes" ) var transactionTypes : ArrayList<TransactionMethodsTypes> = arrayListOf()

)
data class TransactionMethodsTypes(
    @SerializedName("id"                  ) var id                  : String?                        = null,
    @SerializedName("name"                ) var name                : String?                        = null,
    @SerializedName("code"                ) var code                : String?                        = null,
    @SerializedName("metaData"            ) var metaData            : MetaData?                      = MetaData(),
    @SerializedName("status"              ) var status              : String?                        = null,
    @SerializedName("createdById"         ) var createdById         : String?                        = null,
    @SerializedName("updatedById"         ) var updatedById         : String?                        = null,
    @SerializedName("createdAt"           ) var createdAt           : String?                        = null,
    @SerializedName("updatedAt"           ) var updatedAt           : String?                        = null,
    @SerializedName("transactionMethodId" ) var transactionMethodId : String?                        = null,
    @SerializedName("transactionAccounts" ) var transactionAccounts : ArrayList<TransactionAccounts> = arrayListOf()
)
data class TransactionAccounts (

    @SerializedName("id"                ) var id                : String?   = null,
    @SerializedName("title"             ) var title             : String?   = null,
    @SerializedName("value"             ) var value             : String?   = null,
    @SerializedName("metaData"          ) var metaData          : MetaData? = MetaData(),
    @SerializedName("status"            ) var status            : String?   = null,
    @SerializedName("createdById"       ) var createdById       : String?   = null,
    @SerializedName("updatedById"       ) var updatedById       : String?   = null,
    @SerializedName("createdAt"         ) var createdAt         : String?   = null,
    @SerializedName("updatedAt"         ) var updatedAt         : String?   = null,
    @SerializedName("transactionTypeId" ) var transactionTypeId : String?   = null,
    @SerializedName("assignedToUserId"  ) var assignedToUserId  : String?   = null

)