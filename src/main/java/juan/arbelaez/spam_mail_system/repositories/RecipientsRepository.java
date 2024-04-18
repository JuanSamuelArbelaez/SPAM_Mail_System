package juan.arbelaez.spam_mail_system.repositories;

import juan.arbelaez.spam_mail_system.model.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipientsRepository extends JpaRepository<Recipient, Integer> {
    Optional<Recipient> findByEmail(String email);
}
