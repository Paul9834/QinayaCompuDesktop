package entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("id_user")
    @Expose
    private String idUser;
    @SerializedName("name")
    @Expose
    private String name;

    public String getIdUser() {
        return idUser;
    }
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "LoginResponse{" +
                "idUser='" + idUser + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

