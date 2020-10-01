package hu.kincstar.javasetraining.tasks;

public enum Status {
    NEW("Új"), IN_PROGRESS("Folyamatban lévő"), BLOCKED("Blokkolt"), DONE("Kész");

    private final String text;

    Status(String txt) {
        text = txt;
    }

    public String getText() {
        return text;
    }
}
