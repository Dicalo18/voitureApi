package net.javaguides.springboot.crudrestfulwebservice.controller;
import net.javaguides.springboot.crudrestfulwebservice.exception.ResourceNotFoundException;
import net.javaguides.springboot.crudrestfulwebservice.model.Voiture;
import net.javaguides.springboot.crudrestfulwebservice.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/parking")
public class VoitureContoller {

    @Autowired
    private VoitureRepository voitureRepository;
    @GetMapping("/voitures")
    public List<Voiture> getAllVoiture(){
        return voitureRepository.findAll();
    }
    @PostMapping("/voitures" )
    public Voiture createVoiture(@Validated @RequestBody Voiture voiture){
        return voitureRepository.save(voiture);
    }
    @GetMapping("voitures/{id}")
    public ResponseEntity<Voiture> getVoitureById(@PathVariable(value="id") long voitureID) throws ResourceNotFoundException {
    Voiture voiture=voitureRepository.findById(voitureID).orElseThrow(()-> new ResourceNotFoundException("Voiture Introuvable:"+voitureID));
    return ResponseEntity.ok().body(voiture);
    }
    @PutMapping("/voitures/{id}")
    public ResponseEntity<Voiture> updateVoiture(@PathVariable(value="id") long voitureID, @RequestBody Voiture voitureDetails)throws ResourceNotFoundException{
        Voiture voiture=voitureRepository.findById(voitureID).orElseThrow(()-> new ResourceNotFoundException("Voiture Introuvable:"+voitureID));
        voiture.setMarque(voitureDetails.getMarque());
        voiture.setModel(voitureDetails.getModel());
        voiture.setNumero(voitureDetails.getNumero());
        voitureRepository.save(voiture);
        return ResponseEntity.ok().body(voiture);


    }
    @DeleteMapping("/voitures/{id}")
    public ResponseEntity.BodyBuilder deleteVoiture(@PathVariable(value="id") long voitureID)throws ResourceNotFoundException{
        voitureRepository.findById(voitureID).orElseThrow(()-> new ResourceNotFoundException("Voiture Introuvable:"+voitureID));
        voitureRepository.deleteById(voitureID);
        return ResponseEntity.ok();
    }
}
