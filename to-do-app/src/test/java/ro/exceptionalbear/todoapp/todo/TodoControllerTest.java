package ro.exceptionalbear.todoapp.todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TodoController.class)
class TodoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService service;

    @Test
    public void createTodo() throws Exception {
        when(service.save(mock(Todo.class))).thenReturn(new Todo());
        this.mockMvc.perform(post("/users/andrei/todos").contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {"username" : "andrei",
                        "description": "first todo",
                        "targetDate": "2007-12-03",
                        "done": false}"""))
                .andExpect(status().isOk());
    }
}