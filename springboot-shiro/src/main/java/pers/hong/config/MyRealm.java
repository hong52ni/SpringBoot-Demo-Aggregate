package pers.hong.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import pers.hong.dao.UserDao;
import pers.hong.entity.Permission;
import pers.hong.entity.Role;
import pers.hong.entity.User;
import pers.hong.service.UserService;

@Configuration
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return authorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        for (Role role : user.getRoleList()) {
            authorizationInfo.addRole(role.getRoleName());
            for (Permission permission : role.getPermissionList()) {
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }
        return authorizationInfo;
    }

    /**
     * 验证
     *
     * @param authenticationToken
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        //Shiro有时间间隔机制，2分钟内不会重复执行该方法
        User user = userService.getUserByUserName(username);
        if (user != null) {
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getUserPasswrod(), getName());
            return authenticationInfo;
        }
        return null;
    }
}
