package domain.src.java.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    private Long id;
    @NotNull(message = "Country name cannot be null")
    @NotEmpty(message = "Country name cannot be empty")
    @Size(max = 100, message = "Country name must be less than 100 characters")
    private String name;
}
