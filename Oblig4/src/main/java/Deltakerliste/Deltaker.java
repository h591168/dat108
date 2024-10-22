package Deltakerliste;


public class Deltaker {

    private String fornavn;
    private String etternavn;


    private String mobil;  // Unik identifikator for deltakeren (primærnøkkel)
    
    private String kjonn;
    private String passord;
    private String salt;

    // Standardkonstruktør er nødvendig av JPA
    public Deltaker() {
    }

    // Konstruktør med alle felter
    public Deltaker(String fornavn, String etternavn, String mobil, String kjonn, String passord, String salt) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.mobil = mobil;
        this.kjonn = kjonn;
        this.passord = passord;
        this.salt = salt;
    }

    // Gettere og settere
    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getKjonn() {
        return kjonn;
    }

    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    // ToString-metode for enkel utskrift av deltakerobjekter
    @Override
    public String toString() {
        return fornavn + " | " + etternavn + " | " + mobil + " | " + kjonn;
    }
}
