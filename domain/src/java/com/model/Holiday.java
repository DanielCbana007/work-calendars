package domain.src.java.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Holiday {
    private Long id;
    private Long countryId;
    @NotNull(message = "Holiday name cannot be null")
    @NotEmpty(message = "Holiday name cannot be empty")
    @Size(max = 100, message = "Holiday name must be less than 100 characters")
    private String name;

    @Min(value = 1, message = "Day must be greater than or equal to 1")
    @Max(value = 31, message = "Day must be less than or equal to 31")
    private Byte day;

    @Min(value = 1, message = "Month must be greater than or equal to 1")
    @Max(value = 12, message = "Month must be less than or equal to 12")
    private Byte month;

    @Range(min = 1, max = 365, message = "Easter offset days must be between 1 and 365")
    private Short easterOffsetDays;

    @NotNull(message = "Holiday type cannot be null")
    private Long typeId;

    private Date date;
}
