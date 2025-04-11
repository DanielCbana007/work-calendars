package domain.src.java.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {

    @Min(value = 1, message = "ID must be greater than 0")
    private Long id;

    @NotNull(message = "Type cannot be null")
    @NotEmpty(message = "Type cannot be empty")
    @Size(max = 50, message = "Type must be less than 50 characters")
    private String type;

}
