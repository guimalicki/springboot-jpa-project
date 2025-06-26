package com.educandoweb.course.config;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration //Indica que é uma classe de configuração
@Profile("test")//Indica que é uma configuração para perfil de teste
public class TestConfig implements CommandLineRunner { //essa implementação faz essa classe rodar quando a aplicação iniciar

    @Autowired //realiza a instância automática
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception { //O que irá rodar quando iniciar a aplicação
        User s1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User s2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        //salvar no banco de dados
        userRepository.saveAll(Arrays.asList(s1, s2)); //Save all recebe e salva uma lista no BD
    }
}
