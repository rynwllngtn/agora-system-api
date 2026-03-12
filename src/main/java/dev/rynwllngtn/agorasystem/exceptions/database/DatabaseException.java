package dev.rynwllngtn.agorasystem.exceptions.database;

import dev.rynwllngtn.agorasystem.exceptions.AgoraSystemException;

public class DatabaseException extends AgoraSystemException {
    public DatabaseException(String message) {
        super(message);
    }

    public static class DatabaseIntegrityException extends DatabaseException {
        public DatabaseIntegrityException(String message) {
            super(message);
        }
    }

}