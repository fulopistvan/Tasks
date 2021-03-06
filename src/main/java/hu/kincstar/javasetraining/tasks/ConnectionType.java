package hu.kincstar.javasetraining.tasks;

public enum ConnectionType {
    CHILD("Gyermek"), PARENT("Szülő"), PRECEDESSOR("Előd");

    private final String text;

    ConnectionType(String txt) {
        text = txt;
    }

    public String getText() {
        return text;
    }

}
