package com.example.appnewsite.entity;

import com.example.appnewsite.entity.Tamplate.AbstractEntity;
import com.example.appnewsite.entity.enums.Huquq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User extends AbstractEntity implements UserDetails{

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private Position position;

    private boolean enabled;

       @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Huquq> huquqList = this.position.getHuquqList();
        List<GrantedAuthority>grantedAuthorities=new ArrayList<>();
        for (Huquq huquq :huquqList ) {
            grantedAuthorities.add(new SimpleGrantedAuthority(huquq.name()));
    }

    return grantedAuthorities;
        }
 //   @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority>grantedAuthorities=new ArrayList<>();
//        List<Huquq> huquqList = this.position.getHuquqList();
//        for (Huquq huquq :huquqList ) {
//            grantedAuthorities.add(new GrantedAuthority() {
//                @Override
//                public String getAuthority() {
//                    return huquq.name();
//                }
//            });
//        }
//
//        return grantedAuthorities;
//    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}
