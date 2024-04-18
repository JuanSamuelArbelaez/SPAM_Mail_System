package juan.arbelaez.spam_mail_system.services.spams;

import jakarta.validation.constraints.NotNull;
import juan.arbelaez.spam_mail_system.dto.SPAMCountToRecipientDTO;
import juan.arbelaez.spam_mail_system.model.Recipient;
import juan.arbelaez.spam_mail_system.model.SpamMessage;
import juan.arbelaez.spam_mail_system.repositories.RecipientsRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface SPAM_Service {
    @Transactional
    void spamCountToRecipient(SPAMCountToRecipientDTO dto) throws IllegalArgumentException;

    @Transactional
    void sendSPAM(@NotNull Recipient recipient, @NotNull SpamMessage message);
}
