package cl.everis.test.transbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.everis.test.transbank.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

	Users findUserByUsername(String username);
	
}
