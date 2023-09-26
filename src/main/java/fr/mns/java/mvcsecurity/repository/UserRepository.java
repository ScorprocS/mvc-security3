package fr.mns.java.mvcsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.mns.java.mvcsecurity.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String userName);
}
