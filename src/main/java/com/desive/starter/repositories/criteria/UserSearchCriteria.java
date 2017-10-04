package com.desive.starter.repositories.criteria;

import com.desive.starter.entities.User;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;

/*
 Search criteria for teh User entity

 Created by Jack DeSive on 10/3/2017 at 3:15 AM
*/
public class UserSearchCriteria {

    Integer id;
    String username;
    Boolean enabled;

    public UserSearchCriteria(Integer id, String username, Boolean enabled) {
        this.id = id;
        this.username = username;
        this.enabled = enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEmpty(){
        if(id != null || username != null || enabled != null)
            return false;
        return true;
    }

    public static Specification<User> withId(Integer id){
        if(id != null){
            return (((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id)));
        }
        return null;
    }

    public static Specification<User> withUsername(String username){
        if(username != null){
            return (((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("username"), username)));
        }
        return null;
    }

    public static Specification<User> withIsEnabled(Boolean enabled){
        if(enabled != null){
            return (((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("enabled"), enabled)));
        }
        return null;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder(this.getClass().getSimpleName()).append("[ ");
        Arrays.stream(getClass().getDeclaredFields()).filter(field -> {
            field.setAccessible(true);
            try {
                Object value = field.get(this);
                if(value != null)
                    return true;
            } catch (IllegalAccessException e) {}
            return false;
        }).forEach(field -> {
            try {
                stringBuilder.append(field.getName()).append("=").append(field.get(this)).append(" ");
            } catch (IllegalAccessException e) {}
        });
        return stringBuilder.append("]").toString();
    }

}
