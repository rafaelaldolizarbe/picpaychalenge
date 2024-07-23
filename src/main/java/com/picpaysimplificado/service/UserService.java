package com.picpaysimplificado.service;

import com.picpaysimplificado.domain.dto.UserDto;
import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception
    {
        if (sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuário do tipo Logista não está autorizado a realizar transação");

        }

        if (sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo insuficiente para realizar transação");
        }
    }

    public User findUserById(Long id) throws Exception{
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }
    public void saveUser(User user){
        this.userRepository.save(user);
    }

    public User createUser(UserDto user) {
        User newUser = new User(user);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }
}
