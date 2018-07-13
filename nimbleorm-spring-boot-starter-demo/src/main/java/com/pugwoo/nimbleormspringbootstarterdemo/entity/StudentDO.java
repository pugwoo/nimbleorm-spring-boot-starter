package com.pugwoo.nimbleormspringbootstarterdemo.entity;

import java.util.Date;
import com.pugwoo.dbhelper.annotation.Column;
import com.pugwoo.dbhelper.annotation.Table;

@Table("t_student")
public class StudentDO {

	@Column(value = "id", isKey = true, isAutoIncrement = true)
	private Integer id;

	@Column(value = "deleted")
	private Boolean deleted;

	@Column(value = "create_time")
	private Date createTime;

	@Column(value = "update_time")
	private Date updateTime;

	@Column(value = "name")
	private String name;

	@Column(value = "age")
	private Boolean age;

	@Column(value = "intro")
	private byte[] intro;

	@Column(value = "school_id")
	private Integer schoolId;

	@Column(value = "school_snapshot")
	private String schoolSnapshot;

	@Column(value = "course_snapshot")
	private String courseSnapshot;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getAge() {
		return age;
	}

	public void setAge(Boolean age) {
		this.age = age;
	}

	public byte[] getIntro() {
		return intro;
	}

	public void setIntro(byte[] intro) {
		this.intro = intro;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolSnapshot() {
		return schoolSnapshot;
	}

	public void setSchoolSnapshot(String schoolSnapshot) {
		this.schoolSnapshot = schoolSnapshot;
	}

	public String getCourseSnapshot() {
		return courseSnapshot;
	}

	public void setCourseSnapshot(String courseSnapshot) {
		this.courseSnapshot = courseSnapshot;
	}

}