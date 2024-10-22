package Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Util.LoginUtil;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "logout")
public class LogoutController {

	@PostMapping
	public String visUtlogging(HttpSession session, RedirectAttributes ra) {
		if (LoginUtil.erBrukerInnlogget(session)) {
			LoginUtil.loggUtBruker(session);
		}

		ra.addFlashAttribute("redirectMessage", "Du er nå logget ut!");
		return "redirect:" + "login";
	}

}

