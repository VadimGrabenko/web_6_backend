package studying.web_6.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

public class Toast {
    private Long id;
    private String text;

    public Toast(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
