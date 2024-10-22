package Deltakerliste;

import java.util.ArrayList;
import java.util.List;

public class DeltakerRepo {
    private List<Deltaker> deltakere = new ArrayList<>();

    // Finn deltaker basert på fornavn
    public Deltaker findByFornavn(String fornavn) {
        return deltakere.stream()
                .filter(deltaker -> deltaker.getFornavn().equalsIgnoreCase(fornavn))
                .findFirst()
                .orElse(null);
    }

    // Finn deltaker basert på mobil
    public Deltaker findByMobil(String mobil) {
        return deltakere.stream()
                .filter(deltaker -> deltaker.getMobil().equals(mobil))
                .findFirst()
                .orElse(null);
    }

    // Sjekk om deltaker med gitt mobil eksisterer
    public boolean existsByMobil(String mobil) {
        return deltakere.stream()
                .anyMatch(deltaker -> deltaker.getMobil().equals(mobil));
    }

    // Sjekk om deltaker med gitt passord eksisterer
    public boolean existsByPassord(String passord) {
        return deltakere.stream()
                .anyMatch(deltaker -> deltaker.getPassord().equals(passord));
    }

    // Hent alle deltakere sortert etter fornavn i stigende rekkefølge
    public List<Deltaker> findAllByOrderByFornavnAsc() {
        return deltakere.stream()
                .sorted((d1, d2) -> d1.getFornavn().compareToIgnoreCase(d2.getFornavn()))
                .toList();
    }

    // Method to add a Deltaker to the list
    public void addDeltaker(Deltaker deltaker) {
        deltakere.add(deltaker);
    }
}
