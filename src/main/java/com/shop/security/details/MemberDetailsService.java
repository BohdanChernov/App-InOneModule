package com.shop.security.details;

import com.shop.dao.DAOMemberInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberDetailsService implements UserDetailsService {

    @Autowired
    DAOMemberInterface daoMemberInterface;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new MemberDetails(daoMemberInterface.findOneByEmail(username).orElseThrow(IllegalArgumentException::new));
    }
}
