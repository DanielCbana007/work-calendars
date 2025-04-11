package domain.src.java.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Holiday {

    @Min(value = 1, message = "ID must be greater than 0")
    private long id;

    @Min(value = 1, message = "Country ID must be greater than 0")
    private long idCountry;

    @NotNull(message = "Holiday name cannot be null")
    @NotEmpty(message = "Holiday name cannot be empty")
    @Size(max = 100, message = "Holiday name must be less than 100 characters")
    private String name;

    @Min(value = 1, message = "Day must be at least 1")
    @Max(value = 31, message = "Day must be at most 31")
    private int day;

    @NotNull(message = "Month cannot be null")
    @NotEmpty(message = "Month cannot be empty")
    private String month;

    private int easterDays;

    @Min(value = 1, message = "Type ID must be greater than 0")
    private int idType;
}
