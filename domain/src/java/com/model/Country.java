package src.java.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Min(value = 1, message = "ID must be greater than 0")
    private Long id;

    @NotNull(message = "Country name cannot be null")
    @NotEmpty(message = "Country name cannot be empty")
    @Size(max = 100, message = "Country name must be less than 100 characters")
    private String name;
}
