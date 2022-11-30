package com.softic.bitdeposit.services

import com.google.gson.annotations.SerializedName



data class TransactionHistoryResponse(
    @SerializedName("status"      ) var status      : String?         = null,
    @SerializedName("data"        ) var data        : ArrayList<Data> = arrayListOf(),
    @SerializedName("currentPage" ) var currentPage : Int?            = null,
    @SerializedName("pageSize"    ) var pageSize    : Int?            = null,
    @SerializedName("totalPages"  ) var totalPages  : Int?            = null,
    @SerializedName("totalCount"  ) var totalCount  : Int?            = null
)
data class TransactionMethod (

    @SerializedName("id"          ) var id          : String?   = null,
    @SerializedName("name"        ) var name        : String?   = null,
    @SerializedName("code"        ) var code        : String?   = null,
    @SerializedName("metaData"    ) var metaData    : MetaData? = MetaData(),
    @SerializedName("status"      ) var status      : String?   = null,
    @SerializedName("createdById" ) var createdById : String?   = null,
    @SerializedName("updatedById" ) var updatedById : String?   = null,
    @SerializedName("createdAt"   ) var createdAt   : String?   = null,
    @SerializedName("updatedAt"   ) var updatedAt   : String?   = null

)
data class TransactionType (

    @SerializedName("id"                  ) var id                  : String?   = null,
    @SerializedName("name"                ) var name                : String?   = null,
    @SerializedName("code"                ) var code                : String?   = null,
    @SerializedName("metaData"            ) var metaData            : MetaData? = MetaData(),
    @SerializedName("status"              ) var status              : String?   = null,
    @SerializedName("createdById"         ) var createdById         : String?   = null,
    @SerializedName("updatedById"         ) var updatedById         : String?   = null,
    @SerializedName("createdAt"           ) var createdAt           : String?   = null,
    @SerializedName("updatedAt"           ) var updatedAt           : String?   = null,
    @SerializedName("transactionMethodId" ) var transactionMethodId : String?   = null

)
data class Security (

    @SerializedName("twoFactorEnable" ) var twoFactorEnable : Boolean? = null

)
data class Personalize (

    @SerializedName("bgColor"    ) var bgColor    : String? = null,
    @SerializedName("fontSize"   ) var fontSize   : Int?    = null,
    @SerializedName("oddsFormat" ) var oddsFormat : String? = null

)
data class Settings (

    @SerializedName("security"    ) var security    : Security?    = Security(),
    @SerializedName("personalize" ) var personalize : Personalize? = Personalize()

)
data class MetaData (

    @SerializedName("settings" ) var settings : Settings? = Settings()

)
data class User (

    @SerializedName("id"              ) var id              : String?   = null,
    @SerializedName("firstName"       ) var firstName       : String?   = null,
    @SerializedName("lastName"        ) var lastName        : String?   = null,
    @SerializedName("userName"        ) var userName        : String?   = null,
    @SerializedName("dateOfBirth"     ) var dateOfBirth     : String?   = null,
    @SerializedName("email"           ) var email           : String?   = null,
    @SerializedName("isAdmin"         ) var isAdmin         : Boolean?  = null,
    @SerializedName("isSuperUser"     ) var isSuperUser     : Boolean?  = null,
    @SerializedName("isEmailVerified" ) var isEmailVerified : Boolean?  = null,
    @SerializedName("isPhoneVerified" ) var isPhoneVerified : Boolean?  = null,
    @SerializedName("metaData"        ) var metaData        : MetaData? = MetaData(),
    @SerializedName("status"          ) var status          : String?   = null,
    @SerializedName("createdById"     ) var createdById     : String?   = null,
    @SerializedName("updatedById"     ) var updatedById     : String?   = null,
    @SerializedName("createdAt"       ) var createdAt       : String?   = null,
    @SerializedName("updatedAt"       ) var updatedAt       : String?   = null

)
data class TransactionTypeAccount (

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
data class Data (

    @SerializedName("id"                       ) var id                       : String                 = "",
    @SerializedName("tranId"                   ) var tranId                   : String?                 = null,
    @SerializedName("tranRefId"                ) var tranRefId                : String?                 = null,
    @SerializedName("tranType"                 ) var tranType                 : String?                 = null,
    @SerializedName("tranStatus"               ) var tranStatus               : String?                 = null,
    @SerializedName("amount"                   ) var amount                   : Int?                    = null,
    @SerializedName("coin"                     ) var coin                     : Int?                    = null,
    @SerializedName("statusChangedAt"          ) var statusChangedAt          : String?                 = null,
    @SerializedName("metaData"                 ) var metaData                 : MetaData?               = MetaData(),
    @SerializedName("status"                   ) var status                   : String?                 = null,
    @SerializedName("createdById"              ) var createdById              : String?                 = null,
    @SerializedName("updatedById"              ) var updatedById              : String?                 = null,
    @SerializedName("createdAt"                ) var createdAt                : String?                 = null,
    @SerializedName("updatedAt"                ) var updatedAt                : String?                 = null,
    @SerializedName("userId"                   ) var userId                   : String?                 = null,
    @SerializedName("betSiteUserAccountId"     ) var betSiteUserAccountId     : String?                 = null,
    @SerializedName("transactionMethodId"      ) var transactionMethodId      : String?                 = null,
    @SerializedName("transactionTypeId"        ) var transactionTypeId        : String?                 = null,
    @SerializedName("transactionTypeAccountId" ) var transactionTypeAccountId : String?                 = null,
    @SerializedName("userTransactionAccountId" ) var userTransactionAccountId : String?                 = null,
    @SerializedName("senderId"                 ) var senderId                 : String?                 = null,
    @SerializedName("receiverId"               ) var receiverId               : String?                 = null,
    @SerializedName("transactionMethod"        ) var transactionMethod        : TransactionMethod?      = TransactionMethod(),
    @SerializedName("transactionType"          ) var transactionType          : TransactionType?        = TransactionType(),
    @SerializedName("user"                     ) var user                     : User?                   = User(),
    @SerializedName("userbetSiteAccounts"      ) var userbetSiteAccounts      : String?                 = null,
    @SerializedName("transactionTypeAccount"   ) var transactionTypeAccount   : TransactionTypeAccount? = TransactionTypeAccount(),
//    @SerializedName("userTransactionAccount"   ) var userTransactionAccount   : String?                 = Sender(,
    @SerializedName("sender"                   ) var sender                   : Sender?                 = Sender(),
    @SerializedName("receiver"                 ) var receiver                 : Receiver?               = Receiver()

)
data class Sender(
    @SerializedName("id"              ) var id              : String?   = null,
    @SerializedName("firstName"       ) var firstName       : String?   = null,
    @SerializedName("lastName"        ) var lastName        : String?   = null,
    @SerializedName("userName"        ) var userName        : String?   = null,
    @SerializedName("dateOfBirth"     ) var dateOfBirth     : String?   = null,
    @SerializedName("email"           ) var email           : String?   = null,
    @SerializedName("isAdmin"         ) var isAdmin         : Boolean?  = null,
    @SerializedName("isSuperUser"     ) var isSuperUser     : Boolean?  = null,
    @SerializedName("isEmailVerified" ) var isEmailVerified : Boolean?  = null,
    @SerializedName("isPhoneVerified" ) var isPhoneVerified : Boolean?  = null,
    @SerializedName("metaData"        ) var metaData        : MetaData? = MetaData(),
    @SerializedName("status"          ) var status          : String?   = null,
    @SerializedName("createdById"     ) var createdById     : String?   = null,
    @SerializedName("updatedById"     ) var updatedById     : String?   = null,
    @SerializedName("createdAt"       ) var createdAt       : String?   = null,
    @SerializedName("updatedAt"       ) var updatedAt       : String?   = null
)
data class Receiver(
    @SerializedName("id"              ) var id              : String?   = null,
    @SerializedName("firstName"       ) var firstName       : String?   = null,
    @SerializedName("lastName"        ) var lastName        : String?   = null,
    @SerializedName("userName"        ) var userName        : String?   = null,
    @SerializedName("dateOfBirth"     ) var dateOfBirth     : String?   = null,
    @SerializedName("email"           ) var email           : String?   = null,
    @SerializedName("isAdmin"         ) var isAdmin         : Boolean?  = null,
    @SerializedName("isSuperUser"     ) var isSuperUser     : Boolean?  = null,
    @SerializedName("isEmailVerified" ) var isEmailVerified : Boolean?  = null,
    @SerializedName("isPhoneVerified" ) var isPhoneVerified : Boolean?  = null,
    @SerializedName("metaData"        ) var metaData        : MetaData? = MetaData(),
    @SerializedName("status"          ) var status          : String?   = null,
    @SerializedName("createdById"     ) var createdById     : String?   = null,
    @SerializedName("updatedById"     ) var updatedById     : String?   = null,
    @SerializedName("createdAt"       ) var createdAt       : String?   = null,
    @SerializedName("updatedAt"       ) var updatedAt       : String?   = null
)