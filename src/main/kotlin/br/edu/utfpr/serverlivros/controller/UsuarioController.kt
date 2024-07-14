package br.edu.utfpr.serverlivros.controller

import br.edu.utfpr.serverlivros.controller.dto.UsuarioDTO
import br.edu.utfpr.serverlivros.repository.UsuarioRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import kotlin.jvm.optionals.getOrNull

@RestController
@RequestMapping("/usuarios")
class UsuarioController(
    private val usuarioRepository: UsuarioRepository
) {

    @GetMapping
    fun list(): List<UsuarioDTO> {
        return usuarioRepository.findAll().map {
            UsuarioDTO.fromEntity(it)
        }
    }

    @GetMapping("/{cpf}/{telefone}")
    fun findByCpfAndTelefone(@PathVariable cpf: String, @PathVariable telefone: String): ResponseEntity<List<UsuarioDTO>> {
        val usuarios = usuarioRepository.findByCpfAndTelefone(cpf, telefone).map {
            UsuarioDTO.fromEntity(it)
        }
        if (usuarios.isEmpty()) {
            return ResponseEntity.notFound().build()
        }
        return ResponseEntity.ok(usuarios)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): ResponseEntity<UsuarioDTO> {
        val cliente = usuarioRepository.findById(id).getOrNull()
            ?: return ResponseEntity
                .notFound()
                .build()
        return ResponseEntity.ok(UsuarioDTO.fromEntity(cliente))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Unit> {
        usuarioRepository.deleteById(id)
        return ResponseEntity
            .noContent()
            .build()
    }

    @PostMapping
    fun save(@Valid @RequestBody cliente: UsuarioDTO): ResponseEntity<UsuarioDTO> {
        val clienteAtualizado = usuarioRepository.save(cliente.toEntity())
        return ResponseEntity.ok(UsuarioDTO.fromEntity(clienteAtualizado))
    }
}