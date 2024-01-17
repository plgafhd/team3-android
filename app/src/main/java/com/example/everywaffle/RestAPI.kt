package com.example.everywaffle

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface RestAPI {
    @POST("/api/signup")
    suspend fun signup(
        @Body() signup:SignupRequest
    ):SignupResponse

    @POST("/api/signin")
    suspend fun signin(
        @Body() signin:SigninRequest
    ):SigninResponse

    @POST("/api/details/{id}")
    suspend fun updateUserInfo(
        @Path("id") userid:Int,
        @Body() userdetail:UserDetail,
        @Header("Authorization") token:String="Bearer "+MyApplication.prefs.getString("token")
    ):UserDetail

    @GET("/api/details/{id}")
    suspend fun getUserInfo(
        @Path("id") userid:Int,
        @Header("Authorization") token:String="Bearer "+MyApplication.prefs.getString("token")
    ):GetUserDetail

    @POST("/api/details/{id}/change-passowrd")
    suspend fun changepassword(
        @Path("id") userid:Int,
        @Header("Authorization") token:String="Bearer "+MyApplication.prefs.getString("token"),
        @Query("newPassword") newpw:String,
        @Body() empty: Any =Object()
    ): Response<Void>
}