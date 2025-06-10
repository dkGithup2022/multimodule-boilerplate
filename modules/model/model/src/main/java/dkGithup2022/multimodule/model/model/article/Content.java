package dkGithup2022.multimodule.model.model.article;

public record Content(String content) {
    public Content(String content) {
        if (!validContent(content)) {
            throw new IllegalArgumentException("Invalid content");
        }
        this.content = content.trim();
    }

    public static boolean validContent(String content) {
        if (content == null) {
            return false;
        }
        content = content.trim();
        if (content.isBlank()) {
            return false;
        }
        return content.length() <= 20000;
    }
}
