package juan.arbelaez.spam_mail_system.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EMAILS_SENT")
public class EmailSent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer pkid;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Recipient recipient;

    @ManyToOne
    @JoinColumn(name = "MESSAGE_ID")
    private SpamMessage spamMessage;

    @Column
    private Timestamp sentDate;
}

