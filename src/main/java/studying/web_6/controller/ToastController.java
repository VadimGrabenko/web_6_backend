package studying.web_6.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studying.web_6.entity.Toast;
import studying.web_6.service.ToastService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/toasts")
public class ToastController {
    @Autowired
    private ToastService toastService;

    @PostMapping
    public ResponseEntity<Toast> createToast(@RequestBody Toast toast) {
        Toast toastCreated = toastService.createToast(toast);
        return new ResponseEntity<>(toastCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Toast>> getToasts() {
        return ResponseEntity.ok(toastService.getAllToasts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Toast> getToastById(@PathVariable Long id) {
        return toastService.getToastById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Toast> deleteToast(@PathVariable Long id) {
        if (toastService.getToastById(id).isPresent()) {
            toastService.deleteToast(id);
        }
        return ResponseEntity.noContent().build();
    }


}
