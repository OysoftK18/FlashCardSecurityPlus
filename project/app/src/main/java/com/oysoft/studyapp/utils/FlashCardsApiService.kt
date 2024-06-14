package com.oysoft.studyapp.utils

import com.oysoft.studyapp.questions.FlashCard
import retrofit2.http.GET

interface FlashCardsApiService {

    @GET(URL_TVA1)
    suspend fun getTva1(): List<FlashCard>
}
