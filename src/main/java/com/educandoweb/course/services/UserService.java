package com.educandoweb.course.services;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundExpection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

@Service //Indica que é um componente de serviço e qque pode ser injetado por AutoWired. Também há as opções @Componente e @ Repository
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundExpection(id)); //Tenta fazer o get e caso não funcione, lança a excessão personalizada
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id){
        try {
            if (!repository.existsById(id))
                throw new ResourceNotFoundExpection(id);
            repository.deleteById(id);
        } catch (ResourceNotFoundExpection e) {
            throw new ResourceNotFoundExpection(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }

        }

    public User update(Long id, User user){
        User entity = repository.getReferenceById(id); //Prepara o objeto sem mexer no banco de dados
        updateData(entity, user);
        return repository.save(entity);

    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName() != null ? user.getName() : entity.getName());
        entity.setEmail(user.getEmail() != null ? user.getEmail() : entity.getEmail());
        entity.setPhone(user.getPhone() != null ? user.getPhone() : entity.getPhone());

    }
}