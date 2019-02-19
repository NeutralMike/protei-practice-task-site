package server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import client.ManagerService;

public class ManagerServiceImpl extends RemoteServiceServlet implements ManagerService {
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}