
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TaskManagerTest {

    @Test
    void testAddTask() {
        TaskManager manager = new TaskManager();
        manager.addTask("Buy milk");
        assertEquals(1, manager.getTasks().size());
    }

    @Test
    void testMarkTaskAsDone() {
        TaskManager manager = new TaskManager();
        manager.addTask("Do laundry");
        manager.markAsDone("Do laundry");
        assertTrue(manager.getTasks().get(0).isDone());
    }

    @Test
    void testGetPendingTasks() {
        TaskManager manager = new TaskManager();
        manager.addTask("Study TDD");
        manager.addTask("Wash dishes");
        manager.markAsDone("Wash dishes");

        List<TaskManager.Task> pending = manager.getPendingTasks();
        assertEquals(1, pending.size());
        assertEquals("Study TDD", pending.get(0).getDescription());
    }
}
