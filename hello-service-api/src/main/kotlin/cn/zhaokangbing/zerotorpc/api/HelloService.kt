package cn.zhaokangbing.zerotorpc.api

interface HelloService {
    fun hello(hello: Hello): String
}