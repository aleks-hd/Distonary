package com.learn.distonary.model

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class BaseInterceptor private constructor():Interceptor{

    private var responseCode: Int = 0


    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
       val response = chain.proceed(chain.request())
        responseCode - response.code()
        return response
    }

    fun getResponseCode() : ServerResponceCode
    {
        var statusCode = ServerResponceCode.UNDEFINED_ERROR
        when (responseCode / 100){
            1 -> statusCode = ServerResponceCode.INFO
            2 -> statusCode = ServerResponceCode.SUCCESS
            3 -> statusCode = ServerResponceCode.REDIRECTION
            4 -> statusCode = ServerResponceCode.CLIENT_ERROR
            5 -> statusCode = ServerResponceCode.SERVER_ERROR
        }
        return statusCode

    }

    enum class ServerResponceCode{
        INFO,
        SUCCESS,
        REDIRECTION,
        CLIENT_ERROR,
        SERVER_ERROR,
        UNDEFINED_ERROR
    }

    companion object{
        val interceptor : BaseInterceptor
        get() = BaseInterceptor()
    }

}