package Deltakerliste;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeltakerService {

    @Autowired
    private DeltakerRepo deltakerrepo;

    // Hent alle deltakere fra databasen
   // public List<Deltaker> finnAlleDeltakere() {
   //     return deltakerrepo.findAll();
   // }

    // Hent alle deltakere sortert etter fornavn (i stigende rekkefølge)
    public List<Deltaker> finnAlleDeltakereSortert() {
        return deltakerrepo.findAllByOrderByFornavnAsc();
    }

    // Finn en deltaker basert på mobilnummer
    public Deltaker finnMobil(String mobil) {
        return deltakerrepo.findByMobil(mobil);
    }

    // Finn en deltaker basert på fornavn
    public Deltaker finnFornavn(String fornavn) {
        return deltakerrepo.findByFornavn(fornavn);
    }

    // Sjekk om en deltaker med gitt mobilnummer eksisterer
    public boolean deltakerEksisterer(String mobil) {
        return deltakerrepo.existsByMobil(mobil);
    }

    // Sjekk om en deltaker med et gitt passord eksisterer
    public boolean passordEksisterer(String passord) {
        return deltakerrepo.existsByPassord(passord);
    }
}
