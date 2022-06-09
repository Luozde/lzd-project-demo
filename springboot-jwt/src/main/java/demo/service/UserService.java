package demo.service;

import demo.dto.LoginDTO;
import demo.dto.LoginVO;
import demo.entity.User;
import demo.utils.JWTUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户服务
 * @author luozhengde
 */
@Service
public class UserService {

    @Resource
    private GetInformationFromJWT getInformationFromJWT;

    /**
     * 用户信息：模拟用户数据表
     */
    final static Map<String, User> userMap = new HashMap(4){
        {
            // 明文密码分别是user1,user2,user3,user4
            User user1 = new User(1, "user1", "user1", "7d1b5a4329b6478e976508ab9a49ee3d", "user1", "user1");
            User user2 = new User(2, "user2", "user2", "72881e285cdb0f9370dcdf1db0d9a869", "user2", "user2");
            User user3 = new User(3, "user3", "user3", "16bd93afc66e593f3aeedecdf1201ee6", "user3", "user3");
            User user4 = new User(4, "user4", "user4", "47e1c205dd73d4c06405bd08d255e320", "user4", "user4");
            put("user1",user1);
            put("user2",user2);
            put("user3",user3);
            put("user4",user4);
        }
    };

    public String getSaltByAccount(LoginDTO loginDTO) {
        User user = userMap.get(loginDTO.getAccount());
        return user.getSalt();
    }

    public String getPasswordByAccount(LoginDTO loginDTO) {
        User user = userMap.get(loginDTO.getAccount());
        return user.getPassword();
    }

    public LoginVO getUserMsg(LoginDTO loginDTO) {
        User user = userMap.get(loginDTO.getAccount());
        String token = this.getToken(user);
        LoginVO loginVO = new LoginVO();
        loginVO.setToken(token);
        BeanUtils.copyProperties(user,loginVO);
        return loginVO;
    }

    /**
     * 获取用户 token
     * @param meyerUser
     * @return
     */
    public String getToken(User meyerUser) {
        Map<String,String> payload = new HashMap<>();
        payload.put("userId", meyerUser.getId()+"");
        payload.put("username", meyerUser.getUsername());
        payload.put("account", meyerUser.getAccount());
        return JWTUtils.getToken(payload);
    }

    /**
     * 通过token获取用户名
     * @param request
     * @return
     */
    public String getUsernameByJWT(HttpServletRequest request) {
        return this.getInformationFromJWT.getUsernameByJWT(request);
    }
}
