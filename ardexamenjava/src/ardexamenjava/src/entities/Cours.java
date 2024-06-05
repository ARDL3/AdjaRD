package entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cours {
    private int id;
    private LocalDate date;
    private LocalTime heureD;
    private LocalTime heureF;
    private Module module ;
    private Professeur professeur ;

    
    public Cours() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalTime getHeureD() {
        return heureD;
    }
    public void setHeureD(LocalTime heureD) {
        this.heureD = heureD;
    }
    public LocalTime getHeureF() {
        return heureF;
    }
    public void setHeureF(LocalTime heureF) {
        this.heureF = heureF;
    }
    public Module getModule() {
        return module;
    }
    public void setModule(Module module) {
        this.module = module;
    }
    public Professeur getProfesseur() {
        return professeur;
    }
    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
}
