package infrastructure.src.main.java.com.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "holidays")
public class HolidayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_id")
    private Long countryId;

    @Column(name = "name")
    private String name;

    @Column(name = "day")
    private Byte day;

    @Column(name = "month")
    private Byte month;

    @Column(name = "easter_offset_days")
    private Short easterOffsetDays;

    @Column(name = "type_id")
    private Long typeId;

    @Column(name = "holiday_date")
    private Date date;
}
