import sample.IServ;

open module core {
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;

    exports Tanks;
    exports sample;

    uses IServ;
}