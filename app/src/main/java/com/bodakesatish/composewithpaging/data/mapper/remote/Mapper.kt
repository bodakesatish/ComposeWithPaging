package com.bodakesatish.composewithpaging.data.mapper.remote

interface Mapper<From, To> {
    fun From.mapToDataModel(): To
//    fun To.mapFromDataModel(): From
}