package africa.semicolon.recycle_bin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor

@NoArgsConstructor
public class CreateEntryRequest {
    private String body;
    private String title;
}
