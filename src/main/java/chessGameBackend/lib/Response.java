package chessGameBackend.lib;

public class Response {

    private String type;
    private String data;

    private static String ERROR_RESPONSE_TYPE = "error";
    private static String SUCCESS_RESPONSE_TYPE = "success";

    private Response(String type, String data) {
        this.type = type;
        this.data = data;
    }

    public static Response getErrorResponse(String data) {
        return new Response(Response.ERROR_RESPONSE_TYPE, data);
    }

    public static Response getSuccessResponse(String data) {
        return new Response(Response.SUCCESS_RESPONSE_TYPE, data);
    }

    public String getType() {
        return type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
