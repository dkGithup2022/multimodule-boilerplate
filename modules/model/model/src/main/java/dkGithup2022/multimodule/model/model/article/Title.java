package dkGithup2022.multimodule.model.model.article;

public record Title(String title) {
    public static boolean validTitle(String title) {
        if (title == null) return false;
        title = title.trim();
        if (title.isEmpty()) {
            return false;
        }
        return title.length() <= 255;
    }

    public Title(String title){
        if (!validTitle(title))
            throw new IllegalArgumentException("Invalid title");
        this.title = title;
    }
}
