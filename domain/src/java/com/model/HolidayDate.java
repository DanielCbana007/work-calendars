package domain.src.java.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HolidayDate {
    @NotNull(message = "Holiday date cannot be null")
    @PastOrPresent(message = "Holiday date must not be in the future")
    private LocalDate date;

    @NotNull(message = "Holiday name cannot be null")
    @NotEmpty(message = "Holiday name cannot be empty")
    @Size(max = 100, message = "Holiday name must be less than 100 characters")
    private String name;
}
