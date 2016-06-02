package com.edwardvanraak.burendo.communication;

public class ApiConstants {
    public static final String BASE_URL = "https://static.blendle.nl";

    public static final int HTTP_CONNECT_TIMEOUT = 12;
    public static final int HTTP_READ_TIMEOUT = 20;
    public static final int HTTP_WRITE_TIMEOUT = 20;

    public static final String CONTENT_TYPE_MAIN_HEADLINE = "hl1";

    public static final String getPublisherIcon(String publisher){
        return "https://blendle.com/img/providers/" + publisher + "/logo.png";
    }
}
