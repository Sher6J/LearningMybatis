package cn.sher6j.mybatis.cfg;

/**
 * 用于封装执行的SQL语句和结果类型的全限定类名
 * @author sher6j
 * @create 2020-04-11-11:17
 */
public class Mapper {

    private String queryString; //SQL语句
    private String resultType; //实体类的全限定类名

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
