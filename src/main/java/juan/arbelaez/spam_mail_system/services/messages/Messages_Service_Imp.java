package juan.arbelaez.spam_mail_system.services.messages;

import jakarta.validation.constraints.NotNull;
import juan.arbelaez.spam_mail_system.dto.MessageCreationDTO;
import juan.arbelaez.spam_mail_system.model.SpamMessage;
import juan.arbelaez.spam_mail_system.repositories.MessagesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Messages_Service_Imp implements Messages_Service{
    private final MessagesRepository messagesRepository;

    @Override
    @Transactional
    public SpamMessage getMessage(@NotNull int messageId) throws IllegalArgumentException {
        Optional<SpamMessage> optional = messagesRepository.findById(messageId);
        if(optional.isPresent()){
            return optional.get();
        } else throw new IllegalArgumentException("Message with id: "+messageId+" not found");
    }

    @Override
    @Transactional
    public Integer addMessage(MessageCreationDTO dto){
        SpamMessage message = new SpamMessage();
        message.setMessage(dto.message());
        message.setTitle(dto.title());
        message.setSenderEmail(dto.senderEmail());
        return messagesRepository.save(message).getPkid();
    }
}
