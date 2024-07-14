package br.edu.utfpr.serverlivros.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Usuario(
    @Id
    @GeneratedValue
    var id: Int = 0,
    var nome: String = "",
    var cpf: String = "",
    var telefone: String = "",
)