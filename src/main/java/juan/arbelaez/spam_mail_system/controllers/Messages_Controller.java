package juan.arbelaez.spam_mail_system.controllers;

import jakarta.validation.Valid;
import juan.arbelaez.spam_mail_system.dto.MessageCreationDTO;
import juan.arbelaez.spam_mail_system.dto.controllers.ResponseDTO;
import juan.arbelaez.spam_mail_system.services.messages.Messages_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/messages" +
        "")
public class Messages_Controller {
    private final Messages_Service messagesService;

    @PutMapping("/add")
    public ResponseEntity<ResponseDTO<String>> spamCountToAddress(@Valid @RequestBody MessageCreationDTO dto){
        messagesService.addMessage(dto);
        return ResponseEntity.ok(new ResponseDTO<>(false, "SPAM done"));
    }
}