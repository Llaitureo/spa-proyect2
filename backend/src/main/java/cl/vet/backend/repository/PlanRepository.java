package cl.vet.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.vet.backend.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    
}
