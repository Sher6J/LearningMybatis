package cn.sher6j.mybatis.cfg;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义mybatis的配置类
 * @author sher6j
 * @create 2020-04-11-11:14
 */
public class Configuration {

    private String driver;
    private String url;
    private String username;
    private String password;

    private Map<String, Mapper> mappers = new HashMap<String, Mapper>();

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
//        this.mappers = mappers;//会覆盖前一次赋值，这样配置文件中就只能有一个mapper
        this.mappers.putAll(mappers); //追加，而不是覆盖
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
