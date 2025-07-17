package valeriapagliarini.u5d4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import valeriapagliarini.u5d4.entities.Pizza;

@Repository

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
