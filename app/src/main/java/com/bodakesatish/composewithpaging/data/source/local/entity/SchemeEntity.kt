package com.bodakesatish.composewithpaging.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = SchemeEntity.TABLE_NAME)
data class SchemeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Columns.ID)
    val id: Int,
    @ColumnInfo(name = Columns.SCHEME_CODE)
    val schemeCode: Int,
    @ColumnInfo(name = Columns.SCHEME_NAME)
    val schemeName: String
) {

    companion object {
        const val TABLE_NAME = "scheme"
    }

    internal object Columns {
        internal const val ID = "id"
        internal const val SCHEME_CODE = "schemeCode"
        internal const val SCHEME_NAME = "schemeName"
    }

}