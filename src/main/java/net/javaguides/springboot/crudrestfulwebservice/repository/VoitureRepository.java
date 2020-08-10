package net.javaguides.springboot.crudrestfulwebservice.repository;

import net.javaguides.springboot.crudrestfulwebservice.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component("voitureRepository")
public interface VoitureRepository extends JpaRepository<Voiture,Long> {
    Voiture findByMarque(String username);
}
