package juan.arbelaez.spam_mail_system.services.spams;

import jakarta.mail.internet.MimeMessage;
import jakarta.validation.constraints.NotNull;
import juan.arbelaez.spam_mail_system.dto.SPAMCountToRecipientDTO;
import juan.arbelaez.spam_mail_system.model.EmailSent;
import juan.arbelaez.spam_mail_system.model.Recipient;
import juan.arbelaez.spam_mail_system.model.SpamMessage;
import juan.arbelaez.spam_mail_system.repositories.MessagesRepository;
import juan.arbelaez.spam_mail_system.repositories.SentRepository;
import juan.arbelaez.spam_mail_system.services.recipients.Recipient_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SPAM_Service_Imp implements SPAM_Service{
    private final MessagesRepository messagesRepository;
    private final SentRepository sentRepository;
    private final Recipient_Service recipientService;
    private final JavaMailSender javaMailSender;

    @Override
    @Transactional
    public void spamCountToRecipient(SPAMCountToRecipientDTO dto) throws IllegalArgumentException {
        Recipient r = recipientService.getRecipientById(dto.recipient_id());

        Set<Integer> indices = generateSpamIndices(dto.count());

        for(Integer i: indices){
            try {
                SpamMessage m = messagesRepository.getReferenceById(i);
                sendSPAM(r, m);
            }catch (Exception ignored){}
        }

    }

    private  Set<Integer> generateSpamIndices(int numberOfSpams) throws IllegalArgumentException {
        int i = (int) messagesRepository.count();
        if (numberOfSpams > i) {
            throw new IllegalArgumentException("x must be less than or equal to number of messages available");
        }

        Set<Integer> randomNumbers = new HashSet<>();
        Random random = new Random();

        while (randomNumbers.size() < numberOfSpams) {
            int randomNumber = random.nextInt(i) + 1;
            randomNumbers.add(randomNumber);
        }

        return randomNumbers;
    }

    @Override
    @Transactional
    public void sendSPAM(@NotNull Recipient recipient, @NotNull SpamMessage message){
        MimeMessage mime = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(mime, true);
            helper.setSubject(message.getTitle());
            String text = message.getMessage().replace("[NAME]", recipient.getFirstName() + " " + recipient.getLastName());
            helper.setText(text, true);
            helper.setTo(recipient.getEmail());
            helper.setFrom(message.getSenderEmail());
            javaMailSender.send(mime);

            EmailSent e = new EmailSent();
            e.setRecipient(recipient);
            e.setSpamMessage(message);
            e.setSentDate(new Timestamp(new Date().getTime()));
            sentRepository.save(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
