package africa.semicolon.recycle_bin.dto.responses;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeleteEntryResponse {
    private  String title;
    private String message;
}
