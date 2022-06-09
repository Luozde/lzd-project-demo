package demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author luozhengde
 */
@Data
@NoArgsConstructor
public class LoginVO {
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
    private String token;
}
