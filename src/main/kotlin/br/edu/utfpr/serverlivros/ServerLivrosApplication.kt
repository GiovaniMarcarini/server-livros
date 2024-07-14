package br.edu.utfpr.serverlivros

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServerLivrosApplication

fun main(args: Array<String>) {
    runApplication<ServerLivrosApplication>(*args)
}
