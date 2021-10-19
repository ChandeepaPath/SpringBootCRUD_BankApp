package com.example.BankApplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
//    @Autowired
//    private UserRepository repo;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Test
//    public void testCreatecustomer(){
//        User customer =  new User();
//        customer.setEmail("chandeepapathirana@gmail.com");
//        customer.setPassword("chandeepa");
//        customer.setFirstName("Chandeepa");
//        customer.setLastName("Pathirana");
//
//        User savedCustomer = repo.save(customer);
//        User existCutomer = entityManager.find(User.class, savedCustomer.getId());
//        assertThat(existCutomer.getEmail()).isEqualTo(customer.getEmail()) ;
//
//    }
}
