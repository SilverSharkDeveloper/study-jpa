package com.jpa.basic.repository;

import com.jpa.basic.entity.SuperCar;
import com.jpa.basic.type.SuperCarType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SuperCarRepository extends JpaRepository<SuperCar, Long> {
//    @Query("select s from SuperCar s where s.superCarBrand = :superCarType")
    public List<SuperCar> findAllBySuperCarBrand(SuperCarType superCarType);

    @Query("select s from SuperCar s where s.superCarBrand = com.jpa.basic.type.SuperCarType.LAMBORGHINI")
    public List<SuperCar> findAllByLamborghini();
}
