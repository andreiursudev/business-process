package ro.exceptionalbear.todoapp.todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void createTodoIT() {
        ResponseEntity<String> stringResponseEntity = this.testRestTemplate.postForEntity("/users/andrei/todos", new Todo(null, "andrei", "first todo", LocalDate.of(2021, 1, 20), true), String.class);

        assertEquals("""
                {"id":1,"username":"andrei","description":"first todo","targetDate":"2021-01-20","done":true}""", stringResponseEntity.getBody());
    }
}