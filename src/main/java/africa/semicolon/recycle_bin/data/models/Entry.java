package africa.semicolon.recycle_bin.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entry {
    private String title;
    private String body;
    @Id
    private String id;
    private LocalDateTime dateCreated = LocalDateTime.now();

}
