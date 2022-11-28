package com.examcomplexivo.subastainversaservices.services.usuario;

import com.examcomplexivo.subastainversaservices.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> listar();

    Usuario findById(Long id);
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

    Usuario guardar(Usuario usuario);

    public void eliminar(Long id);
    
    public Usuario getUser(Usuario usuario); //obtiene la contraseña y usuario
}
