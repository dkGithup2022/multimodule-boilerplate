package dkGithup2022.multimodule.model.model;

import java.time.LocalDateTime;

public record Timestamps(
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static Timestamps empty() {
        return new Timestamps(null, null);
    }
}