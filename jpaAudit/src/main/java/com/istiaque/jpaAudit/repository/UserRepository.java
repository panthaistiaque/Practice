package com.istiaque.jpaAudit.repository;

import com.istiaque.jpaAudit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mohammad Istiaque Hossain (DS00688) on 29/Aug/2019.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
