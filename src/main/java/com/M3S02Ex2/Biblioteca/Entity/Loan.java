package com.M3S02Ex2.Biblioteca.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PositiveOrZero
    private LocalDate startDate;

    @PositiveOrZero
    private LocalDate endDate;

    @PositiveOrZero
    private Double cost;

    @PositiveOrZero
    private Double total;

    private Boolean status;

}
