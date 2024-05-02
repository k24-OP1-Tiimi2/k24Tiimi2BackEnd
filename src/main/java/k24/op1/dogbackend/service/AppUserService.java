package k24.op1.dogbackend.service;

import k24.op1.dogbackend.domain.AppUser;
import k24.op1.dogbackend.domain.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public boolean isUsernameTaken(String username) {
        AppUser existingUser = appUserRepository.findByUsername(username);
        return existingUser != null;
    }

    public void registerUser(AppUser appUser) {
        // Tarkista, onko käyttäjänimi jo käytössä
        if (isUsernameTaken(appUser.getUsername())) {
            throw new IllegalArgumentException("Username is already taken");
        }

        // Oletusrooli rekisteröityville käyttäjille
        appUser.setRole("ROLE_USER");

        appUserRepository.save(appUser);
    }
}
