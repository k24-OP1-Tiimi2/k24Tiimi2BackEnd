package k24.op1.dogbackend.web;

import k24.op1.dogbackend.domain.AppUser;
import k24.op1.dogbackend.service.AppUserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("appUser", new AppUser());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("appUser") AppUser appUser, Model model) {
        // Tarkista, onko käyttäjänimi jo käytössä
        if (appUserService.isUsernameTaken(appUser.getUsername())) {
            model.addAttribute("error", "Username is already taken");
            return "register";
        }

        // Talleta käyttäjä tietokantaan
        appUserService.registerUser(appUser);

        return "redirect:/dogstore"; // kirjautumissivulle
    }
}
