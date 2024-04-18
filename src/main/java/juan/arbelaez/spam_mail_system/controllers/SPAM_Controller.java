package juan.arbelaez.spam_mail_system.controllers;

import jakarta.validation.Valid;
import juan.arbelaez.spam_mail_system.dto.SPAMCountToRecipientDTO;
import juan.arbelaez.spam_mail_system.dto.controllers.ResponseDTO;
import juan.arbelaez.spam_mail_system.services.spams.SPAM_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
@RequestMapping("/spam" +
        "")
public class SPAM_Controller {
    private final SPAM_Service spamService;

    @PutMapping("/count-to-address")
    public ResponseEntity<ResponseDTO<String>> spamCountToAddress(@Valid @RequestBody SPAMCountToRecipientDTO dto) {
        spamService.spamCountToRecipient(dto);
        return ResponseEntity.ok(new ResponseDTO<>(false, "SPAM done"));
    }
}