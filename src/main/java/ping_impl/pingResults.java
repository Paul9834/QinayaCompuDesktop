package ping_impl;

public class pingResults {
    public int nTimes;
    public int minTime;
    public int maxTime;
    public int avgTime;
    private int totTime;
    
    public void pingResults() {
        nTimes = 0;
        minTime = 0;
        maxTime = 0;
        avgTime = 0;
        totTime = 0;
    }
    
    public void initResults() {
        nTimes = 0;
        minTime = 0;
        maxTime = 0;
        avgTime = 0;
        totTime = 0;
    }
    public void addPing(int iTime) {
        nTimes += 1;
        totTime += iTime;
        if (iTime > maxTime) maxTime = iTime;
        if (iTime < minTime || nTimes == 1) minTime = iTime;
        avgTime = (totTime/nTimes);
    }
}
