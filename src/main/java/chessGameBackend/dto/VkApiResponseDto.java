package chessGameBackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * VK API response dto
 *
 * @author Roman
 */
public class VkApiResponseDto {

    private UserData[] response;
    private ErrorData error;

    public UserData[] getResponse() {
        return response;
    }

    public void setResponse(UserData[] response) {
        this.response = response;
    }

    public ErrorData getError() {
        return error;
    }

    public void setError(ErrorData error) {
        this.error = error;
    }

    public static class UserData {

        private long id;

        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

    public static class ErrorData {

        private int errorCode;

        private String message;

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }


}
