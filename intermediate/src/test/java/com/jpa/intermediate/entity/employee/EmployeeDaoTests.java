package com.jpa.intermediate.entity.employee;

import com.jpa.intermediate.repository.EmployeeDAO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class EmployeeDaoTests {
    @Autowired
    private EmployeeDAO employeeDAO;

    @Test
    public void saveTest(){
        Developer developer = new Developer();
        Planner planner = new Planner();
        Employee employee = new Employee();
        employee.setEmployeeName("123");
        employee.setEmployeeCareer(4);
        employee.setEmployeeBirth(LocalDate.of(1900,2,3));
        employeeDAO.save(employee);
//
        developer.setEmployeeName("한동석");
        developer.setEmployeeBirth(LocalDate.of(2000, 12, 4));
        developer.setEmployeeCareer(1);
        developer.setDeveloperLevel(1);

        planner.setEmployeeName("홍길동");
        planner.setEmployeeBirth(LocalDate.of(1980, 1, 2));
        planner.setEmployeeCareer(10);
        planner.setPlannerOaLevel(2);
        planner.setClientCount(1500);


        employeeDAO.save(developer);
        employeeDAO.save(planner);
    }

    @Test
    public void findTests(){
        Employee employee = employeeDAO.findById(22L).get();
        log.info(String.valueOf(employee instanceof Developer));


//        log.info((Developer)(employeeDAO.findById(22L).get().get);


    }

    @Test
    public void updateTest(){
//        employeeDAO.findById(3L).ifPresent(developer -> developer.setProjectCount(10));
    }

    @Test
    public void findAllByDeveloperTest(){
//        employeeDAO.findAllByDeveloper(10).stream().map(Developer::toString).forEach(log::info);
        employeeDAO.findAllByDeveloper(10);
    }
}
