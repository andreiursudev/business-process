package ro.exceptionalbear.todoapp.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ro.exceptionalbear.todoapp.todo.Todo;

import java.time.LocalDate;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
	
	List<Todo> findByUsername(String username);

	@Transactional
	@Modifying
	@Query("update Todo td set td.description = ?1, td.username = ?2, td.targetDate = ?3, td.done = ?4 where td.id = ?5")
	int updateTodo(String description, String username, LocalDate targetDate, boolean done, int id);
}
