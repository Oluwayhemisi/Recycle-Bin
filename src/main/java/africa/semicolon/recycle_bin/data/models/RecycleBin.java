package africa.semicolon.recycle_bin.data.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RecycleBin {
    private String id;
    private String title;
    @DBRef
    private List<RecycleBin> entries = new ArrayList<>();

}
