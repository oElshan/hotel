package az.isha.hotel.repository;

import az.isha.hotel.entity.Gender;
import org.springframework.data.repository.CrudRepository;

public interface GenderRepository extends CrudRepository<Gender, Long> {

    Gender findGenderByName(String name);

}
