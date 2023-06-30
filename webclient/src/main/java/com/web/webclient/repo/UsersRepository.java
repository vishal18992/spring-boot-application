package com.web.webclient.repo;

import com.web.webclient.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

    Optional<Users> findByName(String name);

    @Query("select u from Users u where u.login = :login")
    public Users getUserByUserName(@Param("login") String login);
}
