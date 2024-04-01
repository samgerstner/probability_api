package pro.samgerstner.probabilityapi.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.samgerstner.probabilityapi.entities.Dice;

public interface DiceRepository extends JpaRepository<Dice, String>
{
}