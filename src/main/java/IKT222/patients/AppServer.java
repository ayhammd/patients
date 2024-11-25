package IKT222.patients;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.server.session.SessionHandler;

public class AppServer {
    public static void main(String[] args) throws Exception {
        // Create a ServletHandler to manage servlet mappings
        ServletHandler servletHandler = new ServletHandler();

        // Add a SessionHandler to enable HTTP session management
        SessionHandler sessionHandler = new SessionHandler();
        sessionHandler.setMaxInactiveInterval(60); // Set session timeout to 1 minute
        sessionHandler.setHandler(servletHandler);

        // Map the servlet to handle all requests
        servletHandler.addServletWithMapping(AppServlet.class, "/*");

        // Create a Jetty server instance on port 8080
        Server server = new Server(8080);
        server.setHandler(sessionHandler);

        // Start the server
        System.out.println("Starting server on http://localhost:8080...");
        server.start();
        server.join();
    }
}
