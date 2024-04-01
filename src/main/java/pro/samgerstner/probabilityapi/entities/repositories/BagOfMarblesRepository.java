package pro.samgerstner.probabilityapi.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.samgerstner.probabilityapi.entities.BagOfMarbles;

public interface BagOfMarblesRepository extends JpaRepository<BagOfMarbles, String>
{
}