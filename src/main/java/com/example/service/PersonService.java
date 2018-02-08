package com.example.service;

import com.example.dao.PersonMapper;
import com.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonMapper personMapper;

    public List<Person> getPersonList() {
        return personMapper.getPersonList();
    }

    public Person findPersonById(String personId) {
        return personMapper.findPersonById(personId);
    }

    @Transactional(rollbackFor = { Exception.class }, propagation = Propagation.REQUIRED)
    public boolean insertPerson(Person person) {
        int cnt = personMapper.insertPerson(person);
        return cnt > 0;
    }

    @Transactional(rollbackFor = { Exception.class }, propagation = Propagation.REQUIRED)
    public boolean updatePerson(Person person) {
        int cnt = personMapper.updatePerson(person);
        return  cnt > 0;
    }

    @Transactional(rollbackFor = { Exception.class }, propagation = Propagation.REQUIRED)
    public boolean deletePerson(String personId) {
        int cnt = personMapper.deletePerson(personId);
        return cnt > 0;
    }
}
