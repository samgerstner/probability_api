package pro.samgerstner.probabilityapi.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.samgerstner.probabilityapi.entities.Coin;

public interface CoinRepository extends JpaRepository<Coin, String>
{
}
