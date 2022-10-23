package APIRest.springbootpostgres.repositories;

import APIRest.springbootpostgres.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
}

