package ua.lpnu.computer_components.security;

public enum ApplicationPermission {
    COMPONENT_ALL("component:all");

    private String permission;

    ApplicationPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}