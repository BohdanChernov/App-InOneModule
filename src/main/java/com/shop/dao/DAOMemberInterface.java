package com.shop.dao;

import com.shop.models.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface DAOMemberInterface extends JpaRepository<Member, String>, JpaSpecificationExecutor<Member> {
    Optional<Member> findOneByEmail(String login);
}
