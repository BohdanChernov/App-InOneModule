package com.shop.forms;

import com.shop.models.member.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberForm {
    private Long id;
    private String email;
    private String name;
    private String lastName;
    private String tel;
    private String password;
    private String repassword;
    private Role role;
}
