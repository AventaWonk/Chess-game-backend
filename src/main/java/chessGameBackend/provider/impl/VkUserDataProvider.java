package chessGameBackend.provider.impl;

import chessGameBackend.dto.VkApiResponseDto;
import chessGameBackend.exception.VkAuthorizationException;
import chessGameBackend.model.User;
import chessGameBackend.provider.UserDataProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.client.RestTemplate;

/**
 * User data provider by VK API
 *
 * @author Roman
 */
public class VkUserDataProvider implements UserDataProvider {

    private final static Logger logger = LogManager.getLogger(VkUserDataProvider.class);
    private final static String VK_API_USER_URL = "https://api.vk.com/method/" +
            "users.get?v=5.52&access_token=";

    private final User userData;

    /**
     * Provides user data by VK API
     *
     * @param vkUserAuthToken User auth token which was obtained by OAuth
     * @throws VkAuthorizationException If VK API returns error object
     */
    public VkUserDataProvider(String vkUserAuthToken) throws VkAuthorizationException {
        logger.info("New VK API call with token:"+ vkUserAuthToken);
        VkApiResponseDto vkApiResponse = new RestTemplate()
                .getForObject(VK_API_USER_URL + vkUserAuthToken, VkApiResponseDto.class);

        VkApiResponseDto.ErrorData errorResponse = vkApiResponse.getError();
        if (errorResponse != null) {
            throw new VkAuthorizationException(
                    errorResponse.getErrorCode(),
                    errorResponse.getMessage()
            );
        }

        VkApiResponseDto.UserData vkUserData = vkApiResponse.getResponse()[0];
        this.userData = new User(
                String.valueOf(vkUserData.getId()),
                null,
                vkUserData.getFirstName(),
                vkUserData.getLastName()
        );
    }

    @Override
    public User getUserData() {
        return this.userData;
    }

}
