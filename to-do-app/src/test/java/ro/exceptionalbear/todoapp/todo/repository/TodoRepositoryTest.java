package ro.exceptionalbear.todoapp.todo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ro.exceptionalbear.todoapp.todo.Todo;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TodoRepositoryTest {

    @Autowired
    TodoRepository repository;

    @Test
    void saveToRepo() {
        Todo result = repository.save(new Todo(null,"Andrei","first todo", LocalDate.of(2021,1,20), true));

        assertEquals(1, (int) result.getId());
    }
}