package net.drewdouglass.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.drewdouglass.Entity.Player;

@Repository
public interface StatRepository extends JpaRepository<Player, Long>{

}
