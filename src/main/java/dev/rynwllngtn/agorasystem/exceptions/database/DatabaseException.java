package dev.rynwllngtn.agorasystem.exceptions.database;

import dev.rynwllngtn.agorasystem.exceptions.AgoraSystemException;

public class DatabaseException extends AgoraSystemException {
    public DatabaseException(String message) {
        super(message);
    }

    public static class ResourceNotFoundException extends DatabaseException {
        public ResourceNotFoundException(Object object) {
            super("Resource not found: ID " + object);
        }
    }

    public static class UserConstraintException extends DatabaseException {
        public UserConstraintException(String message) {
            super(message);
        }
    }

}