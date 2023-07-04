package com.entalpiya.dailytasks.feature_auth.di

import com.entalpiya.dailytasks.feature_auth.data.data_source.api.AuthApiService
import com.entalpiya.dailytasks.feature_auth.data.repository.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun provideAuthRepository(restInterface: AuthApiService): AuthRepositoryImpl {
        return AuthRepositoryImpl(restInterface)
    }

    @Provides
    fun provideAuthRetrofitApi(retrofit: Retrofit): AuthApiService {
        return retrofit.create(AuthApiService::class.java)
    }
}