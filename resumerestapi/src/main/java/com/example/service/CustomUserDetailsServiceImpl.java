package com.example.service;

import com.example.entity.User;
import com.example.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
      User user=userRepo.findByEmail(email);

        if(user!=null){
            UserBuilder builder=org.springframework.security.core.userdetails.User.withUsername(email);

            builder.disabled(false);
            builder.password(user.getPassword());

            String[] authoritiesArr=new String[]{"USER","USER_ROLE"};
            builder.authorities(authoritiesArr);
            return builder.build();
        }else{
            throw new UsernameNotFoundException("User not found.");
        }
    }
}
