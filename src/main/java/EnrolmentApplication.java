import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class EnrolmentApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> classes = new HashSet<>();

    public EnrolmentApplication() {
        singletons.add(new LoginAuthenticator());
        singletons.add(new Enrol());
        singletons.add(CourseCatalog.getInstance());
        singletons.add(new TimetableViewer());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
