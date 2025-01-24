package nathja.finalproject.finalproject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import java.util.Map;

public interface ApiService {

    @POST("/api/auth/register")
    Call<String> register(@Body Map<String, String> body);

    @GET("/api/auth/activate")
    Call<String> activateAccount(@Query("otp") String otp);

    @POST("/api/auth/login")
    Call<String> login(@Body Map<String, String> body);

    @POST("forgot-password")
    Call<Void> forgotPassword(@Query("email") String email);

    @POST("reset-password")
    Call<Void> resetPassword(@Body ResetPasswordRequest request);
}

