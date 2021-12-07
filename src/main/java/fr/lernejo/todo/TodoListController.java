package fr.lernejo.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TodoListController {
    ArrayList laListe;
    public TodoListController() {
        this.laListe = new ArrayList<>();
    }
    @PostMapping(value="/api/todo")
    public void AjoutTodo(@RequestBody Todo todo){
        laListe.add(todo);
    }
    @GetMapping(value="/api/todo")
    public ArrayList GetTodo (){
        return laListe;
    }
}
