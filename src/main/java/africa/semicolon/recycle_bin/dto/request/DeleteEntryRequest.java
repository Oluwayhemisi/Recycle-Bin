package africa.semicolon.recycle_bin.dto.request;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class DeleteEntryRequest {
    private String title;
}
