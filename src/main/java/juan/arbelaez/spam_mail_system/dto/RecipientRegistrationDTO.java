package juan.arbelaez.spam_mail_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record RecipientRegistrationDTO(
        @Email String recipientEmail,
        @NotNull String firstName,
        @NotNull String lastName) {
}
