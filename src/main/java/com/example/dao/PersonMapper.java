package com.example.dao;

import com.example.model.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PersonMapper {

    List<Person> getPersonList();

    Person findPersonById(@Param("personId") String personId);

    int insertPerson(@Param("person") Person person);

    int updatePerson(@Param("person") Person person);

    int deletePerson(@Param("personId") String personId);
}
