package entities;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class UserMachines {

    @SerializedName("user_machine")
    @Expose
    private UserMachine userMachine;

    public UserMachine getUserMachine() {
        return userMachine;
    }

    public void setUserMachine(UserMachine userMachine) {
        this.userMachine = userMachine;
    }



    @Override
    public String toString() {
        return "UserMachines{" +
                "userMachine=" + userMachine +
                '}';
    }
}
