package com.belov.orm;

import com.belov.orm.domain.Contact;
import com.belov.orm.domain.Person;
import com.belov.orm.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor    //конструктор нужен для инжектирования репозитория
@SpringBootApplication
public class OrmApplication implements CommandLineRunner {

    private final PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        var contact = Contact.builder()
                .firstName("Oleg")
                .lastName("Belov")
                .phone("111111")
                .build();

        //createPerson(contact);
        getPersonByIDAndPrint(2);
    }

    void createPerson(Contact contact){
        Person person = Person.builder()
                .contact(contact)
                .age(18)
                .location("Russia, St-Petersburg")
                .build();
        personRepository.createPerson(person);
    }

    void getPersonByIDAndPrint(long id){
        System.out.println(personRepository.findById(id));
    }
}