package fr.eni.ecole.app.ingredients.sauce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SauceRepo extends JpaRepository<Sauce, Long>{

}
