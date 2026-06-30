package com.pdg.backed.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pdg.backed.domain.entity.User;
import com.pdg.backed.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GameRecordUserDetailsService implements UserDetailsService{

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        return new GameRecordUserDetails(user);
    }
}
