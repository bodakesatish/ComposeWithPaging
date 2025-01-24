package com.bodakesatish.composewithpaging.data.mapper.local

import com.bodakesatish.composewithpaging.data.source.local.entity.SchemeEntity
import com.bodakesatish.composewithpaging.domain.model.Scheme

object SchemeLocalMapper : Mapper<SchemeEntity, Scheme> {

    override fun SchemeEntity.mapToDomainModel(): Scheme {
        return Scheme(id = id, schemeCode = schemeCode, schemeName = schemeName)
    }

    override fun Scheme.mapFromDomainModel(): SchemeEntity {
        return SchemeEntity(id = id, schemeCode = schemeCode, schemeName = schemeName)
    }

}