package mg.tiavina.store.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mg.tiavina.store.models.mapping.views.VEntry;

@RestController
public class EntryController {
    
    @PostMapping("/add-entry")
    public void test(@RequestBody VEntry entry) {
        try {
            entry.save(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
