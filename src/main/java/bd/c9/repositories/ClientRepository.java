package bd.c9.repositories;

import bd.c9.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Client c")
    public List<Client> findAll();
}
