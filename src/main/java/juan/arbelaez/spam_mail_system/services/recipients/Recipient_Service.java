package juan.arbelaez.spam_mail_system.services.recipients;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import juan.arbelaez.spam_mail_system.dto.RecipientRegistrationDTO;
import juan.arbelaez.spam_mail_system.model.Recipient;
import org.springframework.transaction.annotation.Transactional;

public interface Recipient_Service {
    @Transactional
    Recipient getRecipientById(@NotNull int recipientId) throws IllegalArgumentException;

    @Transactional
    Recipient getRecipientByEmail(@Email String email) throws IllegalArgumentException;

    @Transactional
    Integer addRecipient(@NotNull RecipientRegistrationDTO dto) throws IllegalArgumentException;
}
