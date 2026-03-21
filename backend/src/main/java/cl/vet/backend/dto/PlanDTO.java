package cl.vet.backend.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Schema(description = "DTO para post, delete y put de Plan")
public class PlanDTO {
    
    public static PlanDTO planDTO;

    @Schema(description = "Identificador único para el plan (Autogenerado).", hidden = true)
    private long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Schema(description = "Nombre del plan.", example = "Plan Básico")
    private String nombre;  

    @NotBlank(message = "La descripción es obligatoria")
    @Schema(description = "Descripción del plan.", example = "Plan básico con servicios esenciales")
    private String descripcion;

    @NotNull(message = "El precio es obligatorio")
    @Schema(description = "Precio del plan.", example = "29.99")
    @Positive(message = "El precio debe ser un número positivo")
    private BigDecimal precio;
    
}
