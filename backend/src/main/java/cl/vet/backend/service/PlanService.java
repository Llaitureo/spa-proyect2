package cl.vet.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.vet.backend.dto.PlanDTO;
import cl.vet.backend.model.Plan;
import cl.vet.backend.repository.PlanRepository;

// Por las puras dudas, no se si esto es necesario, pero lo dejo por si acaso
@Service
public class PlanService {
    
    @Autowired
    private PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public PlanRepository getPlanRepository() {
        return planRepository;
    }

    
    public Plan getPlanById(Long id) {
        return planRepository.findById(id).orElseThrow(() -> new RuntimeException("Plan no encontrado"));
    }

    public PlanDTO getPlanDTO(Long id) {
        Plan plan = planRepository.findById(id).orElseThrow(() -> new RuntimeException("Plan no encontrado"));

        PlanDTO planDTO = new PlanDTO();

        planDTO.setId(plan.getId());
        planDTO.setNombre(plan.getNombre());
        planDTO.setDescripcion(plan.getDescripcion());
        planDTO.setPrecio(plan.getPrecio());
        return planDTO;
    }

    public Plan savePlan(PlanDTO planDTO) {
        Plan plan = new Plan();

        plan.setNombre(planDTO.getNombre());
        plan.setDescripcion(planDTO.getDescripcion());
        plan.setPrecio(planDTO.getPrecio());

        return planRepository.save(plan);
    }

    public Plan updatePlan(Long id, PlanDTO planDTO) {
        Plan plan = planRepository.findById(id).orElseThrow(() -> new RuntimeException("Plan no encontrado"));

        plan.setNombre(planDTO.getNombre());
        plan.setDescripcion(planDTO.getDescripcion());
        plan.setPrecio(planDTO.getPrecio());

        return planRepository.save(plan);
    }

    public void deletePlan(Long id) {
        Plan plan = planRepository.findById(id).orElseThrow(() -> new RuntimeException("Plan no encontrado"));
        planRepository.delete(plan);
    }
}
