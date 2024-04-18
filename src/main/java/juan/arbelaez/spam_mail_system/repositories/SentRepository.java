package juan.arbelaez.spam_mail_system.repositories;

import juan.arbelaez.spam_mail_system.model.EmailSent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SentRepository extends JpaRepository<EmailSent, Integer> {
}
