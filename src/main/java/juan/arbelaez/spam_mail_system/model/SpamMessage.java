package juan.arbelaez.spam_mail_system.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SPAM_MESSAGES")
public class SpamMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer pkid;

    @Column
    private String title;

    @Column
    private String message;

    @Column
    private String senderEmail;

    @OneToMany(mappedBy = "spamMessage")
    private List<EmailSent> emails;
}
