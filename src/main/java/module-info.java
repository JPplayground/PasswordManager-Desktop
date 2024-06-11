module com.jp.passwordmanager {
    requires javafx.controls;
    requires java.sql;
    requires java.datatransfer;
    requires java.desktop;
    requires org.xerial.sqlitejdbc;
    requires org.slf4j;
    requires org.slf4j.simple;
    requires javafx.fxml;

    exports passwordmanager.database;
    exports passwordmanager.util;
    exports passwordmanager.app;
    exports passwordmanager.model;
    exports passwordmanager.controller;

    opens passwordmanager.controller to javafx.fxml;
    opens passwordmanager.app to javafx.fxml;

}
