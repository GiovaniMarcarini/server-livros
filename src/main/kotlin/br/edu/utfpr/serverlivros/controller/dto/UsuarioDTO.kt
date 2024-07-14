package br.edu.utfpr.serverlivros.controller.dto

import br.edu.utfpr.serverlivros.entity.Usuario
import br.edu.utfpr.serverlivros.validator.Telefone
import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.br.CPF

data class UsuarioDTO(
    val id: Int = 0,
    @field:NotBlank(message = "{nome.notblank}")
    val nome: String = "",
    @field:NotBlank(message = "{cpf.notblank}")
    @field:CPF(message = "{cpf.invalido}")
    val cpf: String = "",
    @field:NotBlank(message = "{telefone.notblank}")
    @field:Telefone
    val telefone: String = ""
) {
    fun toEntity(): Usuario = Usuario(
        id = this.id,
        nome = this.nome,
        cpf = this.cpf,
        telefone = this.telefone
    )

    companion object {
        fun fromEntity(usuario: Usuario): UsuarioDTO = UsuarioDTO(
            id = usuario.id,
            nome = usuario.nome,
            cpf = usuario.cpf,
            telefone = usuario.telefone
        )
    }
}