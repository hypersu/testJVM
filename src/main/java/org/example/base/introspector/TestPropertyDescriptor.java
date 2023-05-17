package org.example.base.introspector;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;

public class TestPropertyDescriptor {
    private String user;
    private String password;

    public static void main(String[] args) throws IntrospectionException {
        PropertyDescriptor descriptor = new PropertyDescriptor("user", TestPropertyDescriptor.class);
        System.out.println(descriptor.getPropertyType());
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
