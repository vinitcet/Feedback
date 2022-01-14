package com.vinit.feedback.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Role {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    public Role() {
    }

    public Role(String id) {
        super();
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public boolean isNew() {
        return false;
    }

    public boolean isAdmin() {
        return this.id.equals(ROLE_ADMIN);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Role other = (Role) obj;
        if (this.id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }

    @Override
    public String toString() {
        return this.id;
    }

    public static final String ROLE_ADMIN = "Admin";
    public static final String ROLE_USER = "User";
    public static final Role ADMIN = new Role(ROLE_ADMIN);
    public static final Role USER = new Role(ROLE_USER);


}
