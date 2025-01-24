package com.bodakesatish.composewithpaging.data.mapper.local

interface Mapper<From, To> {
    fun From.mapToDomainModel(): To
    fun To.mapFromDomainModel(): From
}