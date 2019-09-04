package net.drewdouglass.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.drewdouglass.Entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{

	
	Player findByPlayerid(long playerid);
	
}
