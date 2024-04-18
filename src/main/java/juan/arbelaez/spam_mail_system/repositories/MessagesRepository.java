package juan.arbelaez.spam_mail_system.repositories;

import juan.arbelaez.spam_mail_system.model.SpamMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesRepository extends JpaRepository<SpamMessage, Integer> {
}
