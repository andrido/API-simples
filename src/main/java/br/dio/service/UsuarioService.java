package br.dio.service;

import br.dio.model.Usuario;
import br.dio.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Usuario criar(Usuario usuario) {
        if (usuarioRepository.existsByConta_Numero(usuario.getConta().getNumero())) {
            throw new IllegalArgumentException("Número da conta já existe.");
        }
        return usuarioRepository.save(usuario);
    }
}
