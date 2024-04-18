package juan.arbelaez.spam_mail_system.services.messages;

import jakarta.validation.constraints.NotNull;
import juan.arbelaez.spam_mail_system.dto.MessageCreationDTO;
import juan.arbelaez.spam_mail_system.model.SpamMessage;
import org.springframework.transaction.annotation.Transactional;

public interface Messages_Service {
    @Transactional
    SpamMessage getMessage(@NotNull int messageId) throws IllegalArgumentException;

    @Transactional
    Integer addMessage(MessageCreationDTO dto);
}
