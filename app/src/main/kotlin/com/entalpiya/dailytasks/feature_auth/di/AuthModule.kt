package com.entalpiya.dailytasks.feature_auth.di

import android.content.Context
import com.entalpiya.dailytasks.feature_auth.data.data_source.api.AuthApiService
import com.entalpiya.dailytasks.feature_auth.data.repository.AuthRepositoryImpl
import com.entalpiya.dailytasks.feature_auth.domain.repository.AuthRepository
import com.entalpiya.dailytasks.feature_auth.domain.use_case.AuthUseCases
import com.entalpiya.dailytasks.feature_auth.domain.use_case.GetUser
import com.entalpiya.dailytasks.feature_auth.domain.use_case.Login
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun provideAuthRepository(restInterface: AuthApiService): AuthRepository {
        return AuthRepositoryImpl(restInterface)
    }

    @Provides
    fun provideAuthRetrofitApi(retrofit: Retrofit): AuthApiService {
        return retrofit.create(AuthApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthUseCases(repository: AuthRepository): AuthUseCases {
        return AuthUseCases(
            login = Login(repository),
            getUser =  GetUser(repository)
        )
    }
}