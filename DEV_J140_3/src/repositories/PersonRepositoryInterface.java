/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import models.Person;
import models.Domain;
import java.util.List;

/**
 *
 * @author USER
 */
public interface PersonRepositoryInterface {
    List<Person> getPersons();
    Person getPersonById(int id);
    List<Domain> getDomains();
    List<Domain> getDomainByPerson(Person person);
    
}
