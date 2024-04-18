package juan.arbelaez.spam_mail_system.dto.controllers;

import jakarta.validation.constraints.NotNull;

public record ValidationDTO(
        @NotNull String filedName,
        @NotNull String message) {
}
