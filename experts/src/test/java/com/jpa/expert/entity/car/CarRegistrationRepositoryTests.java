package com.jpa.expert.entity.car;

import com.jpa.expert.repository.car.CarRegistrationRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class CarRegistrationRepositoryTests {
    @Autowired
    private CarRegistrationRepository carRegistrationRepository;

    @Test
    public void findAllTest(){
        log.info(carRegistrationRepository.findAll().toString());
    }

    @Test
    public void findAverageOfAgeTest(){
        log.info("평균 나이: " + carRegistrationRepository.findAverageOfAge());
    }

    @Test
    public void findAllCarByAgeTest(){
        log.info(carRegistrationRepository.findAllCarByAge().toString());
    }

    @Test
    public void deleteByAgeTest(){
        carRegistrationRepository.deleteByAge(90);
    }

//    @Test
//    public void test(){
//        log.info(carRegistrationRepository.test().toString());
//    }
}
