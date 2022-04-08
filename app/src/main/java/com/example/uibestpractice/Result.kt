package com.example.uibestpractice

import java.lang.Exception
import java.lang.IllegalArgumentException
/*测试密封类*/
sealed class Result
class Success(val msg:String) : Result()
class Failure(val error:Exception) : Result()

fun getResultMsg(result: Result) = when(result){
    is Success -> result.msg
    is Failure -> "Error is ${result.error.message}"
}