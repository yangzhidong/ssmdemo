package com.yes.dl.shop.service;

import com.yes.dl.shop.db.domain.Person;
import com.yes.dl.shop.db.domain.Message;

import java.util.List;
import java.util.Map;

public interface TestService {

    int save(Person person);
    long insertPerson(Person person);
    boolean addPerson(Person person);
    void createPerson(Person person);

    void deletePerson(int id);
    void removePerson(int id);

    void updatePerson(Person person);

    Person getPerson(int id);
    List<Person> findPerson();

    List<Map<String, Object>> queryPersons();

    void mod(Person person);

    void addTranscationTest();

    boolean insertMessage(Message message);


}
