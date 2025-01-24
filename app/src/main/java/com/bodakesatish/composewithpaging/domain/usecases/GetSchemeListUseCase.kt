package com.bodakesatish.composewithpaging.domain.usecases

import com.bodakesatish.composewithpaging.domain.repository.SchemeRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetSchemeListUseCase @Inject constructor(
    private val schemeRepository: SchemeRepository
) {
    suspend operator fun invoke() = schemeRepository.getSchemes()
}