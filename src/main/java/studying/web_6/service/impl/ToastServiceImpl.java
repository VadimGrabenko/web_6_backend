package studying.web_6.service.impl;

import org.springframework.stereotype.Service;
import studying.web_6.entity.Toast;
import studying.web_6.service.ToastService;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ToastServiceImpl implements ToastService {
    private final Map<Long, Toast> toasts = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong(1);

    @Override
    public Toast createToast(Toast toast) {
        long id = counter.getAndIncrement();
        toast.setId(id);
        toasts.put(id, toast);
        return toast;
    }

    @Override
    public List<Toast> getAllToasts() {
        return new ArrayList<>(toasts.values());
    }

    @Override
    public Optional<Toast> getToastById(Long id) {
        return Optional.ofNullable(toasts.get(id));
    }

    @Override
    public void deleteToast(Long id) {
        toasts.remove(id);
    }
}
