package ru.ccfit.golubevm.movieapp.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ccfit.golubevm.movieapp.core.entity.Person;
import ru.ccfit.golubevm.movieapp.core.entity.TitleCast;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}