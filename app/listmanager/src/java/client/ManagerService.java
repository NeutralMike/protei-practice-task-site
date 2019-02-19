package java.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("MySampleApplicationService")
public interface ManagerService extends RemoteService {

    String getMessage(String msg);
    public static class App {
        private static ManagerServiceAsync ourInstance = GWT.create(ManagerService.class);

        public static synchronized ManagerServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
