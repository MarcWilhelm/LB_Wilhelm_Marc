package ch.zli.m223.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
    private String Vorname;

    @Column(nullable = false)
    private String Nachname;

    @Column(nullable = false)
    private String eMail;

    @Column(nullable = false)
    private String Passwort;

    @Column(nullable = false)
    private Boolean Newsleter;

    @Column(nullable = false)
    private String Rolle;

    @Column(nullable = false)
    private String meineBuchungen;

}
