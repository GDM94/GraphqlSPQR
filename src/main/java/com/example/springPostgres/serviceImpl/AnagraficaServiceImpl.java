package com.example.spqr.serviceImpl;

import java.util.List;

import com.example.springPostgres.model.Anagrafica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnagraficaServiceImpl implements IAnagraficaService{

    @Autowired
    private AnagraficaRepository anagraficaRepository;

    @Override
    public Anagrafica create(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);

    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}