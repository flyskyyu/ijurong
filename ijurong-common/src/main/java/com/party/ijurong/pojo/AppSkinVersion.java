package com.party.ijurong.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "app_skin_version")
public class AppSkinVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 版本号
     */
    private String version;

    /**
     * 说明
     */
    private String introduce;

    /**
     * 生效时间
     */
    @Column(name = "start_time")
    @JsonSerialize(using = DateSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @Column(name = "create_time")
    @JsonSerialize(using = DateSerializer.class)
    private Date createTime;

    private String url1;

    private String url2;

    private String url3;

    private String url4;

    private String url5;

    private String url6;

    private String url7;

    private String url8;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取版本号
     *
     * @return version - 版本号
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    /**
     * 获取说明
     *
     * @return introduce - 说明
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * 设置说明
     *
     * @param introduce 说明
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    /**
     * 获取生效时间
     *
     * @return start_time - 生效时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置生效时间
     *
     * @param startTime 生效时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return url1
     */
    public String getUrl1() {
        return url1;
    }

    /**
     * @param url1
     */
    public void setUrl1(String url1) {
        this.url1 = url1 == null ? null : url1.trim();
    }

    /**
     * @return url2
     */
    public String getUrl2() {
        return url2;
    }

    /**
     * @param url2
     */
    public void setUrl2(String url2) {
        this.url2 = url2 == null ? null : url2.trim();
    }

    /**
     * @return url3
     */
    public String getUrl3() {
        return url3;
    }

    /**
     * @param url3
     */
    public void setUrl3(String url3) {
        this.url3 = url3 == null ? null : url3.trim();
    }

    /**
     * @return url4
     */
    public String getUrl4() {
        return url4;
    }

    /**
     * @param url4
     */
    public void setUrl4(String url4) {
        this.url4 = url4 == null ? null : url4.trim();
    }

    /**
     * @return url5
     */
    public String getUrl5() {
        return url5;
    }

    /**
     * @param url5
     */
    public void setUrl5(String url5) {
        this.url5 = url5 == null ? null : url5.trim();
    }

    /**
     * @return url6
     */
    public String getUrl6() {
        return url6;
    }

    /**
     * @param url6
     */
    public void setUrl6(String url6) {
        this.url6 = url6 == null ? null : url6.trim();
    }

    /**
     * @return url7
     */
    public String getUrl7() {
        return url7;
    }

    /**
     * @param url7
     */
    public void setUrl7(String url7) {
        this.url7 = url7 == null ? null : url7.trim();
    }

    /**
     * @return url8
     */
    public String getUrl8() {
        return url8;
    }

    /**
     * @param url8
     */
    public void setUrl8(String url8) {
        this.url8 = url8 == null ? null : url8.trim();
    }
}