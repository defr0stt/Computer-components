package ua.lpnu.computer_components.security;

import com.google.common.collect.Sets;

import java.util.Set;

public enum ApplicationRole {
    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(ApplicationPermission.COMPONENT_ALL));

    private final Set<ApplicationPermission> permissions;

    ApplicationRole(Set<ApplicationPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationPermission> getPermissions() {
        return permissions;
    }
}
