package demo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 用户数据
 * @author luozhengde
 */
@Data
@Accessors(chain = true)
public class User {
    public User(int id, String username, String account, String password, String salt, String nickname){
        this.id = id;
        this.username = username;
        this.account = account;
        this.password = password;
        this.salt = salt;
        this.nickname = nickname;
    }
    private int id;
    private String username;
    private String account;
    private String password;
    private String salt;
    private String staffNo;
    private String nickname;
    private String avatar;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
}
