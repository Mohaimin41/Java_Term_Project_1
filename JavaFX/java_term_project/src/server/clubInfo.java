package server;

import util.NetworkUtil;

public class clubInfo {
    private String password;
    private boolean isOnline;
    private NetworkUtil networkUtil;

    public clubInfo() {
    }

    public clubInfo(String password, boolean isOnline) {
        this.password = password;
        this.isOnline = isOnline;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }

    public void setNetworkUtil(NetworkUtil networkUtil) {
        this.networkUtil = networkUtil;
    }
}
