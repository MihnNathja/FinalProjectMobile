package nathja.finalproject.finalproject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.HashMap;
import java.util.Map;

public class AuthViewModel extends ViewModel {
    private final ApiService apiService;

    public AuthViewModel() {
        apiService = RetrofitClient.getClient().create(ApiService.class);
    }

    private final MutableLiveData<String> responseLiveData = new MutableLiveData<>();

    public LiveData<String> getResponse() {
        return responseLiveData;
    }

    public void register(String email, String password) {
        Map<String, String> body = new HashMap<>();
        body.put("email", email);
        body.put("password", password);

        apiService.register(body).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                responseLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                responseLiveData.setValue("Error: " + t.getMessage());
            }
        });
    }

    public void activateAccount(String otp) {
        apiService.activateAccount(otp).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                responseLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                responseLiveData.setValue("Error: " + t.getMessage());
            }
        });
    }

    public void login(String email, String password) {
        Map<String, String> body = new HashMap<>();
        body.put("email", email);
        body.put("password", password);

        apiService.login(body).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                responseLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                responseLiveData.setValue("Error: " + t.getMessage());
            }
        });
    }
}

