package ch.zli.m223.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column
    private String Vorname;

    @Column
    private String Nachname;

    @Column
    private String eMail;

    @Column
    private String Passwort;

    @Column
    private Boolean Newsleter;

    @Column
    private String Rolle;

    @OneToMany(mappedBy = "user")
    private Set<Buchung> Buchung;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPasswort() {
        return Passwort;
    }

    public void setPasswort(String passwort) {
        Passwort = passwort;
    }

    public Boolean getNewsleter() {
        return Newsleter;
    }

    public void setNewsleter(Boolean newsleter) {
        Newsleter = newsleter;
    }

    public String getRolle() {
        return Rolle;
    }

    public void setRolle(String rolle) {
        Rolle = rolle;
    }

}
