package ping_impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class qinayaPing {
    public String ipAddress;
    public int pingTimes;
    public int timeOut;
    public boolean error;
    public pingResults results = new pingResults();
    
    public void qinayaPing() {
        ipAddress = "8.8.8.8";   //Ping a Google por defecto
        pingTimes = 4;
        timeOut = 0;   // 0 = sin timeOut
        error = false;
        results.initResults();
    }
    
    public void ping() {
        error = false;
        results.initResults();

        int pos1, pos2, iTime;
        String sTime, line;
        BufferedReader in = null;
        Runtime r = Runtime.getRuntime ();
        String pingCommand = "ping " + ipAddress + " -n " + pingTimes;
        if (timeOut > 0) pingCommand += " -w " + timeOut;
        try {
            Process p = r.exec(pingCommand);
            if (p == null) {
                error = true;
                return;
            }
            in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = in.readLine()) != null) {
                pos2 = line.indexOf("ms TTL");
                if (pos2>0) {
                    line = line.substring(pos2-6, pos2);
                    pos1 = line.indexOf("=");
                    sTime = line.substring(pos1+1, line.length());
                    iTime = Integer.parseInt(sTime);
                    results.addPing(iTime);
                }
            }
            // Si aparece una palabra como = 23ms TTL = 62, el número de ocurrencias = número de pruebas devuelve verdadero
            if (results.nTimes != pingTimes) {
                error = true;
            }
        } catch (Exception ex) {
            error = true;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
            }
        }
        
    }
    
    private static int getCheckResult (String line) {
        Pattern pattern = Pattern.compile("(\\d+ms)(\\s+)(TTL=\\d+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            return 1;
        }
        return 0;
    }
}

