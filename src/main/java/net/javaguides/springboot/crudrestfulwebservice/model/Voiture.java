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

    public Voiture(){
        super();
    }

    public Voiture(long id, String marque, String model) {
        this.id = id;
        this.marque = marque;
        this.model = model;
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
