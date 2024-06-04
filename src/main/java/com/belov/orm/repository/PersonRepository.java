package com.belov.orm.repository;

import com.belov.orm.domain.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //если поставить просто @Component, то будут не очень понятные исключения
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void createPerson(Person person) {
        entityManager.persist(person);
    }

    @Transactional
    public Person findById(long id) {
        // обращение к таблцие идет "Person person"
        var qwery = entityManager.createQuery("select person from Person person WHERE person.id = :id", Person.class);
        qwery.setParameter("id", id);
        try {
            return qwery.getSingleResult();
        } catch (NoResultException e) {
            throw new RuntimeException("Person not found");
        }
    }

    @Transactional
    public List<Person> findAll() {
        var qwery = entityManager.createQuery("select person from Person person", Person.class);
        return qwery.getResultList();
    }

    @Transactional
    public void delete(long id) {
        var person = entityManager.find(Person.class, id);
        entityManager.remove(person);
    }
}
