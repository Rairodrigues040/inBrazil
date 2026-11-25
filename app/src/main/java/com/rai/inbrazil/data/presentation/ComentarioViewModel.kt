package com.rai.inbrazil.data.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rai.inbrazil.data.entity.ComentarioEntity
import com.rai.inbrazil.data.repository.ComentarioRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ComentarioViewModel(
    private val repository: ComentarioRepository
) : ViewModel() {

    // Lista de comentários observada pela interface
    val comentarios = repository.buscarTodos()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    // Cadastrar comentário
    fun inserirComentario(
        nome: String,
        comentario: String,
        fotoUri: String?,
        estado: String
    ) {
        viewModelScope.launch {

            val novoComentario = ComentarioEntity(
                nome = nome,
                comentario = comentario,
                fotoUri = fotoUri,
                estado = estado
            )

            repository.inserir(novoComentario)
        }
    }

    // Editar comentário
    fun atualizarComentario(
        comentario: ComentarioEntity
    ) {
        viewModelScope.launch {
            repository.atualizar(comentario)
        }
    }

    // Excluir comentário
    fun excluirComentario(
        comentario: ComentarioEntity
    ) {
        viewModelScope.launch {
            repository.excluir(comentario)
        }
    }

    // Buscar comentário específico
    suspend fun buscarComentario(id: Long): ComentarioEntity? {
        return repository.buscarPorId(id)
    }
}