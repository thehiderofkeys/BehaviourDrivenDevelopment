import dto.LoginRequestDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/login")
public class LoginAuthenticator {


    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public boolean login(LoginRequestDTO request){
        String username = request.username;
        String password = request.password;
        if (username.equals("username") && password.equals("password")){
            return true;
        }
        return false;
    }

    @GET
    public String helloWorld(){
        return "hello world";
    }

}
