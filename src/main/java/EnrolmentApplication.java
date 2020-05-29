import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class EnrolmentApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public EnrolmentApplication() {
        singletons.add(new LoginAuthenticator());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
