package juan.arbelaez.spam_mail_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record MessageCreationDTO(
        @NotNull String title,
        @Email String senderEmail,
        @NotNull String message) {
}
