package se.knowit.bookit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.knowit.bookit.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
