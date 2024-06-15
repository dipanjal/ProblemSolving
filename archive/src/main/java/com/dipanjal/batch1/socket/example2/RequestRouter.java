package com.dipanjal.batch1.socket.example2;

import java.io.PrintWriter;
import java.time.LocalDateTime;

public class RequestRouter {

    private static final String INDEX = "/";
    private static final String WELCOME = "/welcome";

    public void routePath(String path, PrintWriter response) {
        response.println("HTTP/1.1 200 OK");
        response.println("Content-Type: text/html");
        response.println(); // \r\n

        String content = pageNotFoundHtml();

        if(INDEX.equals(path))
            content = getIndexHtml();
        else if(WELCOME.equals(path))
            content = getWelcomeHtml();

        response.println(content);
    }

    public String getWelcomeHtml() {
        return "<html> <h1> Welcome User </h1> </html>";
    }

    public String getIndexHtml() {
        return String.format("<html> <h1> %s </h1> </html>", LocalDateTime.now());
    }

    public String pageNotFoundHtml() {
        return "<html> <h1> 404 Page not found !! </h1> </html>";
    }
}
