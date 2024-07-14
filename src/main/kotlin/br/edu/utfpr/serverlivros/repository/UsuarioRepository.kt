package br.edu.utfpr.serverlivros.repository

import br.edu.utfpr.serverlivros.entity.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UsuarioRepository : JpaRepository<Usuario, Int> {
    @Query("SELECT u FROM Usuario u WHERE u.cpf = :cpf AND u.telefone = :telefone")
    fun findByCpfAndTelefone(@Param("cpf") cpf: String, @Param("telefone") telefone: String): List<Usuario>
}