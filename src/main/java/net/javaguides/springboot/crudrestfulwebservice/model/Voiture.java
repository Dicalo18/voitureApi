package net.javaguides.springboot.crudrestfulwebservice.model;

import javax.persistence.*;

@Entity

@Table(name="voiture")
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="marque")
    private String marque;
    @Column(name="model")
    private String model;
    @Column(name="numero_ima")
    private String numero;

    public Voiture(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }



    public Voiture(){
        super();
    }

    public Voiture(String marque, String model, String numero) {
        this.marque = marque;
        this.model = model;
        this.numero = numero;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }



}
