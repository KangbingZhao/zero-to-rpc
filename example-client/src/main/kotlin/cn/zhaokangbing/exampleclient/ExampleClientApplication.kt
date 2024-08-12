package cn.zhaokangbing.exampleclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExampleClientApplication

fun main(args: Array<String>) {
    runApplication<ExampleClientApplication>(*args)
}