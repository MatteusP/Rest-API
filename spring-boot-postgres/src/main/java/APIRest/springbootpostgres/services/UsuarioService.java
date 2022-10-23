package APIRest.springbootpostgres.services;

import APIRest.springbootpostgres.models.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario salvarUsuario(Usuario usuario);
    public List<Usuario> getAllUsuarios();

    // public List<Usuario> get(Integer id);

    //public void delete(Integer id);
    public Usuario get(Integer id);

    public void delete(Integer id);
}
