package cl.vet.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.vet.backend.dto.PlanDTO;
import cl.vet.backend.model.Plan;
import cl.vet.backend.repository.PlanRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/planes")
@CrossOrigin("*")
public class PlanController {
    
    private final PlanRepository planRepository;

    public PlanController(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Operation(summary="Obtencion total" , description="Obtiene todos los elementos de la lista Planes.")
    @ApiResponses( value = {
        @ApiResponse(responseCode = "200", description = "Objetos de la lista encontrados"),
        @ApiResponse(responseCode = "404", description = "Ningun objeto encontrado.",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(name = "Ejemplo 404.",
                        summary = "Ejemplo de Objeto no encontrado",
                            value = "{}"
                                    )
                                )
                            )
            
                        }
                    ) 
    @GetMapping
    public List<Plan> getPlanes() {
        return planRepository.findAll();
    }

    @Operation(summary="Obtencion de un plan" , description="Obtiene un plan específico por su ID.")
    @ApiResponses( value = {
        @ApiResponse(responseCode = "200", description = "Objeto de la lista encontrado"),
        @ApiResponse(responseCode = "404", description = "Ningun objeto encontrado.",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(name = "Ejemplo 404.",
                        summary = "Ejemplo de Objeto no encontrado",
                            value = "{}"
                                    )
                                )
                            )
            
                        }
                    ) 
    @GetMapping("/{id}")
    public Plan getPlan(@PathVariable Long id) {
        return planRepository.findById(id).orElseThrow(() -> new RuntimeException("Plan no encontrado"));
    }

    @Operation(summary="Creación de un paciente" , description="Crea un paciente para añadirlo a la lista.")
    @ApiResponses( value= {
        @ApiResponse(responseCode = "200", description = "Plan creado con éxito.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = PlanDTO.class),
                    examples = @ExampleObject(name = "EjemploPlanValido", 
                        summary = "Ejemplo de plan válido",
                            value = "{\"nombre\": \"Plan Deluxe\",\"descripcion\": \"Plan para llorar\", \"precio\": 10000.0}"
                                    )
                                )
                            ),
        @ApiResponse(responseCode = "400", description = "Error de agregación, un campo no posee los requisitos minimos para la creación del Plan.",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(name = "EjemploPlanInvalido", 
                        summary = "Ejemplo de plan no válido",
                            value = "{\"nombre\": \"Plan Deluxe\",\"descripcion\": \"\", \"precio\": 10000,0}"
                                    )
                                )
                            )
                        }
                    )
    @PostMapping
    public Plan postPlan(@RequestBody Plan plan) {
        return planRepository.save(plan);
    }

    @Operation(summary="Actualización de un plan" , description="Actualiza un plan específico por su ID.")
    @ApiResponses( value = {
        @ApiResponse(responseCode = "200", description = "Plan actualizado con éxito.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = PlanDTO.class),
                    examples = @ExampleObject(name = "EjemploPlanValido", 
                        summary = "Ejemplo de plan válido",
                            value = "{\"nombre\": \"Plan Deluxe\",\"descripcion\": \"Plan para llorar\", \"precio\": 10000.0}"
                                    )
                                )
                            ),
        @ApiResponse(responseCode = "400", description = "Error de actualización, un campo no posee los requisitos minimos para la actualización del Plan.",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(name = "EjemploPlanInvalido", 
                        summary = "Ejemplo de plan no válido",
                            value = "{\"nombre\": \"Plan Deluxe\",\"descripcion\": \"Plan para llorar\", \"precio\": 10000,0}"
                                    )
                                )
                            ),
        @ApiResponse(responseCode = "404", description = "Ningun objeto encontrado.",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(name = "Ejemplo 404.",
                        summary = "Ejemplo de Objeto no encontrado",
                            value = "{}"
                                    )
                                )
                            )
            
                        }
                    )
    @PutMapping("/{id}")
    public Plan putPlan(@PathVariable Long id, @RequestBody Plan plan) {
        Plan existingPlan = planRepository.findById(id).orElseThrow(() -> new RuntimeException("Plan no encontrado"));

        existingPlan.setNombre(plan.getNombre());
        existingPlan.setDescripcion(plan.getDescripcion());
        existingPlan.setPrecio(plan.getPrecio());

        return planRepository.save(existingPlan);
    }

    @Operation(summary="Eliminación de un plan" , description="Elimina un plan específico por su ID.")
    @ApiResponses( value = {
        @ApiResponse(responseCode = "200", description = "Plan eliminado con éxito."),
        @ApiResponse(responseCode = "404", description = "Ningun objeto encontrado.",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(name = "Ejemplo 404.",
                        summary = "Ejemplo de Objeto no encontrado",
                            value = "{}"
                                    )
                                )
                            )
            
                        }
                    )
    @DeleteMapping("/{id}")
    public void deletePlan(@PathVariable Long id) {
        Plan existingPlan = planRepository.findById(id).orElseThrow(() -> new RuntimeException("Plan no encontrado"));
        planRepository.delete(existingPlan);
    }
    
}
