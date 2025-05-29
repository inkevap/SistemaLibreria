package sistemalibreria.model;

public enum UserRole {
    GUEST("Invitado"),
    USER("Usuario"),
    ADMIN("Administrador"),
    NULL("No Asignado");

    private final String descripcion;

    UserRole(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
