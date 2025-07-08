package com.app.latihan_jetpack.service.api

import com.app.latihan_jetpack.model.request.LoginRequest
import com.app.latihan_jetpack.model.request.RegisterRequest
import com.app.latihan_jetpack.model.response.LoginResponse
import com.app.latihan_jetpack.model.response.NotesResponse
import com.app.latihan_jetpack.model.response.RegisterResponse
import retrofit2.Response
import retrofit2.http.*

/**
 * Interface `ApiService` mendefinisikan endpoint-endpoint API
 * yang dapat digunakan oleh aplikasi untuk melakukan komunikasi ke server.
 *
 * Semua fungsi dideklarasikan sebagai `suspend` karena menggunakan coroutine (asynchronous).
 */
interface ApiService {

    /**
     * Endpoint untuk melakukan registrasi pengguna baru.
     *
     * @param request objek `RegisterRequest` yang berisi data pendaftaran.
     * @return `Response<RegisterResponse>` yang dikirim dari server.
     */
    @POST("api/register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>

    /**
     * Endpoint untuk melakukan login pengguna.
     *
     * @param request objek `LoginRequest` yang berisi username dan password.
     * @return `Response<LoginResponse>` dari server berisi token dan data pengguna.
     */
    @POST("/api/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("/api/notes")
    suspend fun getAllNotes(): NotesResponse


}
