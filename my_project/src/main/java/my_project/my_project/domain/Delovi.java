/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_project.my_project.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name= "delovi")
@NamedQueries({ @NamedQuery(name = "Delovi.findAll", query = "SELECT d FROM Delovi d"),
		@NamedQuery(name = "Delovi.findById", query = "SELECT d FROM Delovi d WHERE d.iddelovi = :iddelovi"),
		@NamedQuery(name = "Delovi.findByNaziv", query = "SELECT d FROM Delovi d WHERE d.naziv = :naziv")})
public class Delovi implements Serializable{
    private static final long serialVersionUID= 845236465L;
    
    @Id
    @Column(name= "iddelovi")
    private Long iddelovi;
    
    @Column(name= "naziv")
    private String naziv;
    
    @Column(name= "cena")
    private Double cena;
    
    @Column(name= "kompatibilnost")
    private String komp;

    public Delovi() {
    }

    public Delovi(Long iddelovi, String naziv, Double cena, String komp) {
        this.iddelovi = iddelovi;
        this.naziv = naziv;
        this.cena = cena;
        this.komp = komp;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getIddelovi() {
        return iddelovi;
    }

    public String getNaziv() {
        return naziv;
    }

    public Double getCena() {
        return cena;
    }

    public String getKomp() {
        return komp;
    }

    public void setIddelovi(Long iddelovi) {
        this.iddelovi = iddelovi;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public void setKomp(String komp) {
        this.komp = komp;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.iddelovi);
        hash = 79 * hash + Objects.hashCode(this.naziv);
        hash = 79 * hash + Objects.hashCode(this.cena);
        hash = 79 * hash + Objects.hashCode(this.komp);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Delovi other = (Delovi) obj;
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.komp, other.komp)) {
            return false;
        }
        if (!Objects.equals(this.iddelovi, other.iddelovi)) {
            return false;
        }
        if (!Objects.equals(this.cena, other.cena)) {
            return false;
        }
        return true;
    }

   
    
}
