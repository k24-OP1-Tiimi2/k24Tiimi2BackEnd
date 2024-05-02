package k24.op1.dogbackend.web;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import k24.op1.dogbackend.domain.AppUser;
import k24.op1.dogbackend.domain.AppUserRepository;

@Service
public class UserDetailService implements UserDetailsService {
    private final AppUserRepository repository;

    public UserDetailService(AppUserRepository appUserRepository) {
        this.repository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPassword(),
                AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }
}
