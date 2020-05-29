import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/login")
public class LoginAuthenticator {


    @POST
    public boolean login(String username, String password){

        // Create a fake login method
        if (username.equals("username") && password.equals("password")){
            return true;
        }
        else {
            return false;
        }
    }

    @GET
    public String helloWorld(){
        return "hello world";
    }

}
