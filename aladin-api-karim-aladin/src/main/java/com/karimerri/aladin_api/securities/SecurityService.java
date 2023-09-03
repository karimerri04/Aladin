/*
 * package com.karimerri.aladin_api.securities;
 *
 * import java.util.ArrayList; import java.util.List; import java.util.UUID;
 *
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service; import
 * org.springframework.transaction.annotation.Transactional; import
 * org.springframework.util.StringUtils;
 *
 * import com.karimerri.aladin_api.entities.Permission; import
 * com.karimerri.aladin_api.entities.Role; import
 * com.karimerri.aladin_api.entities.User; import
 * com.karimerri.aladin_api.repositories.PermissionRepository; import
 * com.karimerri.aladin_api.repositories.RoleRepository; import
 * com.karimerri.aladin_api.repositories.UserRepository; import
 * com.karimerri.aladin_api.utils.AlaDinException;
 *
 * @Service
 *
 * @Transactional public class SecurityService {
 *
 * @Autowired UserRepository userRepository;
 *
 * @Autowired PermissionRepository permissionRepository;
 *
 * @Autowired RoleRepository roleRepository;
 *
 * public Role createRole(Role role) { final Role roleByName =
 * getRoleByName(role.getName()); if (roleByName != null) throw new
 * AlaDinException("Role " + role.getName() + " already exist"); final
 * List<Permission> persistedPermissions = new ArrayList<>(); final
 * List<Permission> permissions = role.getPermissions(); if (permissions !=
 * null) for (final Permission permission : permissions) if (permission.getId()
 * != null)
 * persistedPermissions.add(permissionRepository.getOne(permission.getId()));
 *
 * role.setPermissions(persistedPermissions); return roleRepository.save(role);
 * }
 *
 * public User createUser(User user) { final User userByEmail =
 * findUserByEmail(user.getEmail()); if (userByEmail != null) throw new
 * AlaDinException("Email " + user.getEmail() + " already in use"); final
 * List<Role> persistedRoles = new ArrayList<>(); final List<Role> roles =
 * user.getRoles(); if (roles != null) for (final Role role : roles) if
 * (role.getId() != null)
 * persistedRoles.add(roleRepository.getOne(role.getId()));
 * user.setRoles(persistedRoles);
 *
 * return userRepository.save(user); }
 *
 * public User findUserByEmail(String email) { return
 * userRepository.findByEmail(email); }
 *
 * public List<Permission> getAllPermissions() { return
 * permissionRepository.findAll(); }
 *
 * public List<Role> getAllRoles() { return roleRepository.findAll(); }
 *
 * public List<User> getAllUsers() { return userRepository.findAll(); }
 *
 * public Role getRoleById(Integer id) { return roleRepository.getOne(id); }
 *
 * public Role getRoleByName(String roleName) { return
 * roleRepository.findByName(roleName); }
 *
 * public User getUserById(Integer id) { return userRepository.getOne(id); }
 *
 * public String resetPassword(String email) { final User user =
 * findUserByEmail(email); if (user == null) throw new
 * AlaDinException("Invalid email address"); final String uuid =
 * UUID.randomUUID().toString(); user.setPasswordResetToken(uuid); return uuid;
 * }
 *
 * public void updatePassword(String email, String token, String password) {
 * final User user = findUserByEmail(email); if (user == null) throw new
 * AlaDinException("Invalid email address"); if (!StringUtils.hasText(token) ||
 * !token.equals(user.getPasswordResetToken())) throw new
 * AlaDinException("Invalid password reset token"); user.setPassword(password);
 * user.setPasswordResetToken(null); }
 *
 * public Role updateRole(Role role) { final Role persistedRole =
 * getRoleById(role.getId()); if (persistedRole == null) throw new
 * AlaDinException("Role " + role.getId() + " doesn't exist");
 * persistedRole.setDescription(role.getDescription()); final List<Permission>
 * updatedPermissions = new ArrayList<>(); final List<Permission> permissions =
 * role.getPermissions(); if (permissions != null) for (final Permission
 * permission : permissions) if (permission.getId() != null)
 * updatedPermissions.add(permissionRepository.getOne(permission.getId()));
 * persistedRole.setPermissions(updatedPermissions); return
 * roleRepository.save(persistedRole); }
 *
 * public User updateUser(User user) { final User persistedUser =
 * getUserById(user.getId()); if (persistedUser == null) throw new
 * AlaDinException("User " + user.getId() + " doesn't exist");
 *
 * final List<Role> updatedRoles = new ArrayList<>(); final List<Role> roles =
 * user.getRoles(); if (roles != null) for (final Role role : roles) if
 * (role.getId() != null) updatedRoles.add(roleRepository.getOne(role.getId()));
 * persistedUser.setRoles(updatedRoles); return
 * userRepository.save(persistedUser); }
 *
 * public boolean verifyPasswordResetToken(String email, String token) { final
 * User user = findUserByEmail(email); if (user == null) throw new
 * AlaDinException("Invalid email address"); if (!StringUtils.hasText(token) ||
 * !token.equals(user.getPasswordResetToken())) return false; return true; }
 *
 * }
 */