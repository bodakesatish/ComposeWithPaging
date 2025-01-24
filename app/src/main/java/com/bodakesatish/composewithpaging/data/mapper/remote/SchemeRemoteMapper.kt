package com.bodakesatish.composewithpaging.data.mapper.remote

import com.bodakesatish.composewithpaging.data.source.local.entity.SchemeEntity
import com.bodakesatish.composewithpaging.data.source.remote.entity.SchemeDto

object SchemeRemoteMapper : Mapper<SchemeDto, SchemeEntity> {

    override fun SchemeDto.mapToDataModel(): SchemeEntity {
        return SchemeEntity(id = id, schemeCode = schemeCode, schemeName = schemeName)
    }



}