package com.jiggy.sample.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jiggy.sample.framework.searchengine.DefaultSearchCriteria;
import com.jiggy.sample.framework.searchengine.SearchCriteria;

/**
 * NextBooks form based authentication realm.
 * 
 * Created on Sept 1, 2012
 * 
 * @author jmalkan
 * @version $Revision$
 */
public class UserRealm extends AuthorizingRealm {
  private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);
  
  private UserCredentialsService userCredentialsService;
  
  /**
   * Creates a new instance of com.jiggy.sample.security.UserRealm.java and Performs Initialization
   */
  public UserRealm() {
    setAuthenticationTokenClass(UsernamePasswordToken.class);
    setCredentialsMatcher(new HashedCredentialsMatcher(Sha512Hash.ALGORITHM_NAME));
  }
  
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	  logger.info("begin doGetAuthorizationInfo");
      SessionProfile profile = SessionUtil.getProfile();
      UserPrincipal userPrincipal = (UserPrincipal) getAvailablePrincipal(principals);
      
//      if (profile == null) {
//          UserOrgProfile userOrgProfile =
//              this.userOrgProfileServiceProvider.get()
//                                                .findByUserOrg(userPrincipal.getSourcedId(), userPrincipal.getOrgId());
//          profile = userOrgProfile.toSessionProfile();
//      }
//      Set<String> roles = Sets.newHashSet(profile.getRole().getName());
//      Set<Permission> permissions = profile.getRole().getPermissions();
//      Set<org.apache.shiro.authz.Permission> shiroPermissions = new HashSet<org.apache.shiro.authz.Permission>();
//      
//      for (Permission permission:permissions)
//          shiroPermissions.add(new WildcardPermission(permission.getPermissionValue()));
//      
//      SimpleAuthorizationInfo authInfo = new SimpleAuthorizationInfo(roles);
      SimpleAuthorizationInfo authInfo = new SimpleAuthorizationInfo();
//      
//      authInfo.setObjectPermissions(shiroPermissions);
//      
      return authInfo;
  }
  
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    logger.info("begin doGetAuthenticationInfo");
	User user = null;
    UserPrincipal userPrincipal = null;
    SimpleAuthenticationInfo simpleAuthenticationInfo = null;
    UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
    
    SearchCriteria userCredSearchCriteria = new DefaultSearchCriteria();
    userCredSearchCriteria.addFilter("username", usernamePasswordToken.getUsername());
    UserCredentials userCredentials = userCredentialsService.findOne(userCredSearchCriteria);
    logger.warn("userCredentials=", userCredentials);
    
    if (userCredentials == null) {
    	String cred = "admin";
    	Sha256Hash sha256Hash = new Sha256Hash(cred);
        logger.info("password={}", sha256Hash.toHex());
        
    	userCredentials = new UserCredentials();
    	userCredentials.setUsername(cred);
    	userCredentials.setPassword(sha256Hash.toHex());
    }
    
    if (userCredentials != null) {
      logger.warn("Validating user credential against Credentials.");
      user = userCredentials.getUser();
      
      userPrincipal = new UserPrincipal(user.getId());
      
      simpleAuthenticationInfo = new SimpleAuthenticationInfo(userPrincipal, userCredentials.getPassword(), UserRealm.class.getSimpleName());
    }
    
    return simpleAuthenticationInfo;
  }
}