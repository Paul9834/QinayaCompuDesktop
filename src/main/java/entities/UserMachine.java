package entities;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class UserMachine {
    @SerializedName("plan_activo")
    @Expose
    private boolean planActivo;
    @SerializedName("tiempo_disponible")
    @Expose
    private String tiempoDisponible;
    @SerializedName("sistema_operativo")
    @Expose
    private String sistemaOperativo;
    @SerializedName("logo_so")
    @Expose
    private String logoSo;
    @SerializedName("plan")
    @Expose
    private String plan;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("server_status")
    @Expose
    private Integer serverStatus;

    public boolean isPlanActivo() {
        return planActivo;
    }

    public void setPlanActivo(boolean planActivo) {
        this.planActivo = planActivo;
    }

    public String getTiempoDisponible() {
        return tiempoDisponible;
    }

    public void setTiempoDisponible(String tiempoDisponible) {
        this.tiempoDisponible = tiempoDisponible;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getLogoSo() {
        return logoSo;
    }

    public void setLogoSo(String logoSo) {
        this.logoSo = logoSo;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(Integer serverStatus) {
        this.serverStatus = serverStatus;
    }

    @Override
    public String toString() {
        return "UserMachine{" +
                "planActivo=" + planActivo +
                ", tiempoDisponible='" + tiempoDisponible + '\'' +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                ", logoSo='" + logoSo + '\'' +
                ", plan='" + plan + '\'' +
                ", url='" + url + '\'' +
                ", serverStatus=" + serverStatus +
                '}';
    }
}
