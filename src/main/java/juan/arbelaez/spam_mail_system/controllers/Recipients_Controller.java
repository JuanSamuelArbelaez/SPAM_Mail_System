package juan.arbelaez.spam_mail_system.controllers;

import jakarta.validation.Valid;
import juan.arbelaez.spam_mail_system.dto.RecipientRegistrationDTO;
import juan.arbelaez.spam_mail_system.dto.controllers.ResponseDTO;
import juan.arbelaez.spam_mail_system.services.recipients.Recipient_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/recipients" +
        "")
public class Recipients_Controller {
    private final Recipient_Service recipientService;

    @PutMapping("/add")
    public ResponseEntity<ResponseDTO<String>> addRecipient(@Valid @RequestBody RecipientRegistrationDTO dto) {
        recipientService.addRecipient(dto);
        return ResponseEntity.ok(new ResponseDTO<>(false, "SPAM done"));
    }
}