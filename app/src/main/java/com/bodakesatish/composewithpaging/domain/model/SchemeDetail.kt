package com.bodakesatish.composewithpaging.domain.model

data class SchemeDetail (
    var data: List<SchemeNavDataResponse>,
    val meta: SchemeMeta,
    val status: String
)

data class SchemeNavDataResponse(
    val date: String,
    val nav: String,
    var schemeCode: Int = 0
)

data class SchemeMeta(
    var fund_house: String = "",
    var scheme_category: String = "",
    var scheme_code: Int = 0,
    var scheme_name: String = "",
    var scheme_type: String = "",
    var schemeLastSyncedDate: String = ""
)