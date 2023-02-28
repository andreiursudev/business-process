package ro.exceptionalbear.todoapp.todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void createTodoIT() {
        ResponseEntity<String> stringResponseEntity = this.testRestTemplate.postForEntity("/users/andrei/todos", new Todo(), String.class);

        assertEquals("""
                {"id":1,"username":"andrei","description":null,"targetDate":null,"done":false}""", stringResponseEntity.getBody());
    }
}