package chessGameBackend.service;

import chessGameBackend.model.User;

public interface UserService {
    void addUser(User user);
    void deleteUser(int userId);
    void updateUser(User user);
    boolean isUserExists(String login);
}
