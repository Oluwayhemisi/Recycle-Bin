package africa.semicolon.recycle_bin.controller;


import africa.semicolon.recycle_bin.dto.request.CreateEntryRequest;
import africa.semicolon.recycle_bin.dto.request.DeleteEntryRequest;
import africa.semicolon.recycle_bin.dto.responses.ApiResponse;
import africa.semicolon.recycle_bin.exceptions.DuplicateRequestExceptions;
import africa.semicolon.recycle_bin.service.EntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/entry")
public class EntryController {

    @Autowired
    private EntryService entryService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateEntryRequest createEntryRequest){
    try {
        var entryResponse =entryService.createEntry(createEntryRequest);
        ApiResponse response = new ApiResponse(true,entryResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }catch (DuplicateRequestExceptions ex){
        ApiResponse response = new ApiResponse(false,ex.getMessage() );
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody DeleteEntryRequest deleteEntryRequest){
        try{
            var deleteResponse = entryService.deleteEntry(deleteEntryRequest);
            ApiResponse response = new ApiResponse(true,deleteResponse);
            return  new ResponseEntity<>(response, HttpStatus.FOUND);
        }catch (DuplicateRequestExceptions ex){
            ApiResponse response = new ApiResponse(false,ex.getMessage());
            return  new ResponseEntity<>(response,HttpStatus.NO_CONTENT);
        }
    }


}
