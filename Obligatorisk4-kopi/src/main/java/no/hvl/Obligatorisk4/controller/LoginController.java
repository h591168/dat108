package no.hvl.Obligatorisk4.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.Obligatorisk4.deltakerliste.Deltaker;
import no.hvl.Obligatorisk4.deltakerliste.DeltakerRepo;
import no.hvl.Obligatorisk4.deltakerliste.DeltakerService;
import no.hvl.Obligatorisk4.util.InputValidator;
import no.hvl.Obligatorisk4.util.LoginUtil;

@Controller
@RequestMapping(value = "login")
public class LoginController {
    @Autowired
    public DeltakerRepo deltakerrepo;

    @Autowired
    public InputValidator inputvalid;

    @Autowired
    DeltakerService deltakers;

    @Value("${app.url.login}")
    private String LOGIN_URL;
    @Value("${app.url.deltagerliste}")
    private String DELTAGERLISTE_URL;

    @GetMapping
    public String visLogin() {
        return LOGIN_URL;
    }

    @PostMapping
    public String loggInn(RedirectAttributes ra, HttpServletRequest rq, 
                          @RequestParam(name = "mobil") String mobil,
                          @RequestParam(name = "passord") String passord) {

        // Check if the mobil exists in the system
        if (!deltakerrepo.existsByMobil(mobil)) {
            ra.addFlashAttribute("errorMsg", "Ugyldig mobilnummer eller passord.");
            return "redirect:" + LOGIN_URL;
        }

        // Find the participant by mobil
        Deltaker deltaker = deltakers.finnMobil(mobil);
        
        // Validate the provided password against the stored password
        if (deltaker.getPassord().equals(passord)) {
            // Successful login
            LoginUtil.loggInnBruker(rq, mobil, passord);
            ra.addFlashAttribute("deltaker", mobil);
            return "redirect:" + DELTAGERLISTE_URL;
        } else {
            // Invalid password
            ra.addFlashAttribute("errorMsg", "Ugyldig brukernavn og/eller passord");
            return "redirect:" + LOGIN_URL;
        }
    }
}
