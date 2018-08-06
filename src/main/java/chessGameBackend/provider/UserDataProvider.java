package chessGameBackend.provider;

import chessGameBackend.model.User;

/**
 * User data provider
 *
 * @author Roman
 */
public interface UserDataProvider {

    /**
     * Returns an user data wrapped in User model
     *
     * @return an user data wrapped in User model
     */
    User getUserData();
}
