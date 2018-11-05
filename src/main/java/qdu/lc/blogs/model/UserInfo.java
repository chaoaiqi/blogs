package qdu.lc.blogs.model;

import java.util.Date;

public class UserInfo {
    private Integer id;

    private String telephone;

    private Date lasttime;

    private String avatar;

    private String lastsite;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getLastsite() {
        return lastsite;
    }

    public void setLastsite(String lastsite) {
        this.lastsite = lastsite == null ? null : lastsite.trim();
    }
}