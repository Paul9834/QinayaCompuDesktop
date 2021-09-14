package entities;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class UserMachine {

    @SerializedName("plan_activo")
    @Expose
    private String planActivo;
    @SerializedName("tiempo_disponible")
    @Expose
    private String tiempoDisponible;
    @SerializedName("used_trial")
    @Expose
    private String usedTrial;
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
    private String serverStatus;
    @SerializedName("rdp_host")
    @Expose
    private String rdpHost;
    @SerializedName("rdp_port")
    @Expose
    private String rdpPort;
    @SerializedName("rdp_username")
    @Expose
    private String rdpUsername;
    @SerializedName("rdp_password")
    @Expose
    private String rdpPassword;

    public String getPlanActivo() {
        return planActivo;
    }

    public void setPlanActivo(String planActivo) {
        this.planActivo = planActivo;
    }

    public String getTiempoDisponible() {
        return tiempoDisponible;
    }

    public void setTiempoDisponible(String tiempoDisponible) {
        this.tiempoDisponible = tiempoDisponible;
    }

    public String getUsedTrial() {
        return usedTrial;
    }

    public void setUsedTrial(String usedTrial) {
        this.usedTrial = usedTrial;
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

    public String getServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(String serverStatus) {
        this.serverStatus = serverStatus;
    }

    public String getRdpHost() {
        return rdpHost;
    }

    public void setRdpHost(String rdpHost) {
        this.rdpHost = rdpHost;
    }

    public String getRdpPort() {
        return rdpPort;
    }

    public void setRdpPort(String rdpPort) {
        this.rdpPort = rdpPort;
    }

    public String getRdpUsername() {
        return rdpUsername;
    }

    public void setRdpUsername(String rdpUsername) {
        this.rdpUsername = rdpUsername;
    }

    public String getRdpPassword() {
        return rdpPassword;
    }

    public void setRdpPassword(String rdpPassword) {
        this.rdpPassword = rdpPassword;
    }

    @Override
    public String toString() {
        return "UserMachine{" +
                "planActivo='" + planActivo + '\'' +
                ", tiempoDisponible='" + tiempoDisponible + '\'' +
                ", usedTrial='" + usedTrial + '\'' +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                ", logoSo='" + logoSo + '\'' +
                ", plan='" + plan + '\'' +
                ", url='" + url + '\'' +
                ", serverStatus='" + serverStatus + '\'' +
                ", rdpHost='" + rdpHost + '\'' +
                ", rdpPort='" + rdpPort + '\'' +
                ", rdpUsername='" + rdpUsername + '\'' +
                ", rdpPassword='" + rdpPassword + '\'' +
                '}';
    }
}
