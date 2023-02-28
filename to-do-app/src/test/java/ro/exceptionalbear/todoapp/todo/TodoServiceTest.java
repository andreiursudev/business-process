package ro.exceptionalbear.todoapp.todo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.exceptionalbear.todoapp.todo.repository.TodoRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @InjectMocks
    private TodoService service;

    @Mock
    private TodoRepository repository;

    @Test
    void save() {
        Todo expected = new Todo();
        when(repository.save(any())).thenReturn(expected);
        Todo result = service.save(expected);

        assertEquals(expected, result);
    }
}