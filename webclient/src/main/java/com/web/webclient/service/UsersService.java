package com.web.webclient.service;

import com.web.webclient.entity.Users;
import com.web.webclient.model.SignupDto;
import com.web.webclient.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public long create(SignupDto signupDto) {
        Users user = usersRepository.save(toEntity(signupDto));
        return user.getId();
    }

    public Optional<Users> findByLogin(String login){
        Optional<Users> user;
        user = usersRepository.findByName(login);
        return user;
    }

    private Users toEntity(SignupDto signupDto) {
        Users user = new Users();
        user.setName(signupDto.getName());
        user.setLogin(signupDto.getLogin());
        user.setPassword(signupDto.getPassword());
        user.setActive(signupDto.getActive());
        user.setRole(signupDto.getRole());
        return user;
    }
}
