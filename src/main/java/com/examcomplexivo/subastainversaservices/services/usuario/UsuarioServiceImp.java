package com.examcomplexivo.subastainversaservices.services.usuario;

import com.examcomplexivo.subastainversaservices.models.Usuario;
import com.examcomplexivo.subastainversaservices.repositories.UsuarioRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Service
public class UsuarioServiceImp implements UsuarioService{

	private final EntityManager entityManager;
	
	
	@Autowired
    public UsuarioServiceImp(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
	
    @Autowired
    private UsuarioRespository usuarioRespository;

    @Override
    public List<Usuario> listar() {
        return (List<Usuario>) usuarioRespository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRespository.findById(id).orElse(new Usuario());
    }

    @Override
    public Optional<Usuario> findByNombreUsuario(String nombreUsuario) {
        return usuarioRespository.findByNombreUsuario(nombreUsuario);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRespository.save(usuario);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRespository.deleteById(id);
    }
    
    @Override
	@Transactional(readOnly= true)
	    public Usuario getUser(Usuario userDetails) {
	        TypedQuery<Usuario> typedQuery = entityManager.createQuery(
	                "FROM Usuario WHERE contrasenia_usuario = :contrasenia_usuario AND nombreUsuario = :nombreUsuario", Usuario.class);
	        try {
	        	Usuario user = typedQuery.setParameter("contrasenia_usuario", userDetails.getContraseniaUsuario()).setParameter("nombreUsuario", userDetails.getNombreUsuario()).getSingleResult();
	            return user;
	        } catch (Exception e) {
	            return null;
	        }
	    }

}
