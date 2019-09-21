package net.drewdouglass.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.drewdouglass.Entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

	
}
