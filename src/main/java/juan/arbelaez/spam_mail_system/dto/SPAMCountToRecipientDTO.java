package juan.arbelaez.spam_mail_system.dto;

import jakarta.validation.constraints.NotNull;

public record SPAMCountToRecipientDTO(
        @NotNull  int count,
        @NotNull  int recipient_id
) {
}
