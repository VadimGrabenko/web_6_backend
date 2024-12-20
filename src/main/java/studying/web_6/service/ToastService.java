package studying.web_6.service;

import studying.web_6.entity.Toast;
import java.util.*;

public interface ToastService {

    Toast createToast(Toast toast);

    List<Toast> getAllToasts();

    Optional<Toast> getToastById(Long id);

    void deleteToast(Long id);
}
