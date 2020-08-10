package net.javaguides.springboot.crudrestfulwebservice.repository;

import net.javaguides.springboot.crudrestfulwebservice.model.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class VoitureRepositoryTest {


    @Autowired
    private VoitureRepository voitureRepository;


    @Test
    public void testSaveVoiture(){

            Voiture voiture1 = new Voiture("Toyota","corolla","56xd");
            voitureRepository.save(voiture1);
            Voiture voiture2 = voitureRepository.findByMarque(voiture1.getMarque());

            assertNotNull(voiture1);
            assertEquals(voiture2.getMarque(), voiture1.getMarque());
            assertEquals(voiture2.getModel(), voiture1.getModel());
            assertEquals(voiture2.getNumero(), voiture1.getNumero());

    }

    @Test
    public void testGetVoiture() {

        Voiture voiture1 = new Voiture("Toyota", "corolla", "56xd");

        voitureRepository.save(voiture1);
        Voiture voiture2 = voitureRepository.findByMarque("Toyota");
        assertNotNull(voiture1);
        assertEquals(voiture1.getMarque(), voiture2.getMarque());
        assertEquals(voiture1.getModel(), voiture2.getModel());
        assertEquals(voiture1.getNumero(), voiture2.getNumero());
    }
    @Test
    public void deleteVoiture(){

            Voiture voiture = new Voiture("Toyota", "camri", "12");
            voitureRepository.save(voiture);
            voitureRepository.delete(voiture);

    }

    @Test
    public void testUpdateVoiture(){

            Voiture voiture = new Voiture("Toyota", "corolla", "56xd");
            Voiture voiture1 = voitureRepository.save(voiture);
            Optional<Voiture> optional=voitureRepository.findById(voiture1.getId());
            Voiture voiture2 = optional.get();
            voiture2.setMarque("BMW");
            voiture2.setModel("v6");
            voiture2.setNumero("FR235");
            voitureRepository.save(voiture2);


    }

    @Test
    public void getAllVoitureTest() {

            Voiture voiture1 = new Voiture("Toyota", "corolla", "56xd");
            voitureRepository.save(voiture1);
            assertNotNull(voitureRepository.findAll());
    }

    @Test

    public void deleteVoitureById(){


            Voiture voiture1 = new Voiture("Toyota", "corolla", "56xd");
            Voiture voiture2 = voitureRepository.save(voiture1);
            voitureRepository.save(voiture2);
            voitureRepository.deleteById(voiture2.getId());


    }
}