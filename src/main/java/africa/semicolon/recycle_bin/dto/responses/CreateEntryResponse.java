package africa.semicolon.recycle_bin.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor



public class CreateEntryResponse {
    private String message;
    private String title;
    private String theDate;
}
