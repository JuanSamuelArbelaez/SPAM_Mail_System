package juan.arbelaez.spam_mail_system.services.recipients;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import juan.arbelaez.spam_mail_system.dto.RecipientRegistrationDTO;
import juan.arbelaez.spam_mail_system.model.Recipient;
import juan.arbelaez.spam_mail_system.repositories.RecipientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Recipient_Service_Imp implements Recipient_Service{
    private final RecipientsRepository recipientsRepository;

    @Override
    @Transactional
    public  Recipient getRecipientById(@NotNull int recipientId) throws IllegalArgumentException{
        Optional<Recipient> optional = recipientsRepository.findById(recipientId);
        if(optional.isPresent()){
            return optional.get();
        }else throw new IllegalArgumentException("Recipient with id: "+recipientId+" not found");
    }

    @Override
    @Transactional
    public  Recipient getRecipientByEmail(@Email String email) throws IllegalArgumentException{
        Optional<Recipient> optional = recipientsRepository.findByEmail(email);
        if(optional.isPresent()){
            return optional.get();
        }else throw new IllegalArgumentException("Recipient with email: "+email+" not found");
    }

    @Override
    @Transactional
    public Integer addRecipient(@NotNull RecipientRegistrationDTO dto) throws IllegalArgumentException{
        Recipient recipient = new Recipient();
        try{
            getRecipientByEmail(dto.recipientEmail());
        }catch (IllegalArgumentException ignore){
            recipient.setEmail(dto.recipientEmail());
            recipient.setFirstName(dto.firstName());
            recipient.setLastName(dto.lastName());
            return recipientsRepository.save(recipient).getPkid();
        }
        throw new IllegalArgumentException("Email already in use");
    }
}
