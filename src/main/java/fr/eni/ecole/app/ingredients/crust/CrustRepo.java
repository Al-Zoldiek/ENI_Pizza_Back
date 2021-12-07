package fr.eni.ecole.app.ingredients.crust;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrustRepo extends JpaRepository<Crust, Long>{

}
