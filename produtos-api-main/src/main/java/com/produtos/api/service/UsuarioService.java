package com.produtos.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.produtos.api.dto.UsuarioDTO;
import com.produtos.api.model.Usuario;
import com.produtos.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public UsuarioDTO buscarUsuarioPeloId(Long id){
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

        if (usuarioOpt.isPresent()) {
            return usuarioOpt.get().toDTO();
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario atualizarUsuario(Long id, Usuario dadosUsuario){
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            usuario.setNome(dadosUsuario.getNome());
            usuario.setDatadenascimento(dadosUsuario.getDatadenascimento());
            usuario.setCpf(dadosUsuario.getCpf());
            usuario.setEmail(dadosUsuario.getEmail());

            return usuarioRepository.save(usuario);
        }

        return null;
        
    }
}
