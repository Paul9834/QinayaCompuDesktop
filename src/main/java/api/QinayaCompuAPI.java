package api;
import entities.LoginResponse;
import entities.LoginUser;
import entities.UserMachines;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface QinayaCompuAPI {



    @FormUrlEncoded
    @POST("api/mobile/user_home_desktop")
    Call<UserMachines> getDesktop(@Field("id") String id);

    @POST("api/mobile/login")
    Call<LoginResponse> authUser(@Body LoginUser login);



}
