import java.util.ArrayList;
import java.util.List;

public class TodoService {
    public static List<Todo> todos=new ArrayList<>();
    static {
        todos.add(new Todo("Java Todo"));
        todos.add(new Todo("spring Todo"));
        todos.add(new Todo("Servlet Todo"));
    }
    public List<Todo> retriveTodo(){
        return todos;
    }
}
