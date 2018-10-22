package com.yes.dl.shop.service.impl;

import com.yes.dl.shop.db.domain.Person;
import com.yes.dl.shop.db.domain.Message;
import com.yes.dl.shop.db.mapper.TestMapper;
import com.yes.dl.shop.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("testService")
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public int save(Person person) {
        System.out.println(testMapper.save(person));
        return 0;
    }

    @Override
    public long insertPerson(Person person) {
        System.out.println(testMapper.insertPerson(person));
        return 0;
    }

    @Override
    public boolean addPerson(Person person) {
        System.out.println(testMapper.addPerson(person));
        return false;
    }

    @Override
    public void createPerson(Person person) {
        testMapper.createPerson(person);
    }

    @Override
    public void deletePerson(int id) {
        testMapper.deletePerson(id);
    }

    @Override
    public void removePerson(int id) {
        testMapper.removePerson(id);
    }

    @Override
    public void updatePerson(Person person) {
        testMapper.updatePerson(person);
    }

    @Override
    public Person getPerson(int id) {
        return testMapper.getPerson(id);
    }

    @Override
    public List<Person> findPerson() {
        return testMapper.findPerson();
    }

    @Override
    public List<Map<String, Object>> queryPersons() {
        return testMapper.queryPersons();
    }

    @Override
    public void mod(Person person) {
        testMapper.updatePerson(person);
    }

    @Override
    public void addTranscationTest() {
        Person person = new Person();
        person.setUserName("Michael");
        testMapper.insertPerson(person);

        person = new Person();
        person.setUserName("jerry");
        int a = 10/0;
        testMapper.insertPerson(person);
    }
    @Override
    public boolean insertMessage(Message message) {
        return testMapper.insertMessage(message);
    }



}
