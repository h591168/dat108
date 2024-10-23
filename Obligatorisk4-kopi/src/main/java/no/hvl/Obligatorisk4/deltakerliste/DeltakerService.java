package no.hvl.Obligatorisk4.deltakerliste;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DeltakerService {

    private List<Deltaker> deltakerListe = new ArrayList<>();

    // Constructor for initializing the list with hardcoded participants
    public DeltakerService() {
        // Example of hardcoded participants with plain passwords
        deltakerListe.add(new Deltaker("Ola", "Nordmann", "12345678", "Mann", "password1"));
        deltakerListe.add(new Deltaker("Kari", "Nordkvinne", "87654321", "Kvinne", "password2"));
        deltakerListe.add(new Deltaker("Per", "Hansen", "56781234", "Mann", "password3"));
        deltakerListe.add(new Deltaker("Lise", "Johansen", "43215678", "Kvinne", "password4"));
        deltakerListe.add(new Deltaker("Morten", "Jensen", "21436587", "Mann", "password5"));
    }

    public List<Deltaker> finnAlleDeltakere() {
        return deltakerListe; // Return the hardcoded list
    }

    public Deltaker finnMobil(String mobil) {
        // Find Deltaker by mobile number
        return deltakerListe.stream()
                            .filter(d -> d.getMobil().equals(mobil))
                            .findFirst()
                            .orElse(null);
    }

    public Deltaker finnFornavn(String fornavn) {
        // Find Deltaker by first name
        return deltakerListe.stream()
                            .filter(d -> d.getFornavn().equalsIgnoreCase(fornavn))
                            .findFirst()
                            .orElse(null);
    }
}
