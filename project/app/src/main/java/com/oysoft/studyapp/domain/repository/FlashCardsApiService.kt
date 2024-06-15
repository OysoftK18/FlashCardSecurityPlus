package com.oysoft.studyapp.domain.repository

import com.oysoft.studyapp.questions.FlashCard
import com.oysoft.studyapp.utils.URL_TVA1
import retrofit2.http.GET

interface FlashCardsApiService {

    @GET(URL_TVA1)
    suspend fun getTva1(): List<FlashCard>
}
