package cl.vet.backend.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.vet.backend.model.Plan;
import cl.vet.backend.repository.PlanRepository;

@ExtendWith(MockitoExtension.class)
public class PlanControllerTest {

    @Mock
    private PlanRepository planRepository;
    
    @InjectMocks
    private PlanController planController;


    @Test
    public void testGetPlanesById(){ //ID valido
        Plan plan = new Plan();
        
        plan = new Plan();
        plan.setId(1L);

        when(planRepository.findById(plan.getId())).thenReturn(java.util.Optional.of(plan));

        Plan resultado = planController.getPlan(plan.getId());

        assertNotNull(resultado);//Verifica que el plan no venga vacio ni nulo
        assertEquals(plan.getId(), resultado.getId());

        verify(planRepository, times(1)).findById(plan.getId());//Verifica si el repository respendió
    }

    @Test
    public void testGetPlanesWithoutId(){ //ID erroneo
        Long planId = 99L;

        when(planRepository.findById(planId)).thenReturn(Optional.empty());//simula el no encontrar algo

        RuntimeException exception = assertThrows(RuntimeException.class, () -> { //Da una exception al no encontrar con la id 99
            planController.getPlan(planId);
        });
        assertEquals("Plan no encontrado", exception.getMessage());
        
        verify(planRepository, times(1)).findById(planId);
    }

}
