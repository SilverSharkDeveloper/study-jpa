package com.jpa.basic.entity;

import com.jpa.basic.type.SuperCarType;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @ToString
@Table(name="TBL_SUPER_CAR")
public class SuperCar {
    @Id @GeneratedValue
    private Long id;
    @NotNull @Enumerated(EnumType.STRING)
    private SuperCarType superCarBrand;
    private String superCarName;
    private String superCarColor;
    private Long superCarPrice;
    private LocalDateTime superCarReleaseDate;
}






















