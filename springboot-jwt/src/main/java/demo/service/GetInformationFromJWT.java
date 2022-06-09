package demo.service;

import com.auth0.jwt.interfaces.DecodedJWT;
import demo.utils.JWTUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 从 token 获取数据
 * @author luozhengde
 */
@Component
public class GetInformationFromJWT {

    public int getUserIdByJWT(HttpServletRequest request){
        String token = request.getHeader("token");
        DecodedJWT verify = JWTUtils.verify(token);
        return Integer.parseInt(verify.getClaim("userId").asString());
    }

    public int getRoleIdByJWT(HttpServletRequest request){
        String token = request.getHeader("token");
        DecodedJWT verify = JWTUtils.verify(token);
        return Integer.parseInt(verify.getClaim("roleId").asString());
    }

    public String getUsernameByJWT(HttpServletRequest request){
        String token = request.getHeader("token");
        DecodedJWT verify = JWTUtils.verify(token);
        return verify.getClaim("username").asString();
    }
}
