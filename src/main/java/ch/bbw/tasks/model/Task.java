package ch.bbw.tasks.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Task {
    private long id;
    private String description;
    private boolean completed;
}
