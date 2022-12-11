package hu.david.urban.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://rapidapi.p.rapidapi.com"

    private const val CONNECT_TIMEOUT: Long = 60
    private const val READ_TIMEOUT: Long = 60
    private const val WRITE_TIMEOUT: Long = 60

    private const val RAPID_HOST = "x-rapidapi-host"
    private const val RAPID_KEY = "x-rapidapi-key"

    private const val RAPID_HOST_VALUE = "rawg-video-games-database.p.rapidapi.com"
    private const val RAPID_KEY_VALUE = "40af1f4ddfmshbd18f55db9525f8p17ec1bjsn623c47c69fe8"

    @Provides
    @Singleton
    internal fun provideHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
            requestBuilder.addHeader(RAPID_HOST, RAPID_HOST_VALUE)
            requestBuilder.addHeader(RAPID_KEY, RAPID_KEY_VALUE)
            val request = requestBuilder.build()
            chain.proceed(request)
        }
    }

    @Provides
    @Singleton
    internal fun provideOkHttp(
        interceptor: Interceptor
    ): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        httpClient.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        httpClient.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        httpClient.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        return httpClient.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}
