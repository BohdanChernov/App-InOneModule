package com.shop.services;

import com.shop.forms.MemberForm;
import com.shop.models.member.Member;
import com.shop.models.member.Role;
import com.shop.dao.DAOMemberInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private DAOMemberInterface daoMemberInterface;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void registration(MemberForm memberForm) {
        String hasPass = passwordEncoder.encode(memberForm.getPassword());

        Member member = Member.builder()
                .email(memberForm.getEmail())
                .name(memberForm.getName())
                .lastName(memberForm.getLastName())
                .tel(memberForm.getTel())
                .password(hasPass)
                .role(Role.USER)
                .build();

        daoMemberInterface.save(member);
    }
}
