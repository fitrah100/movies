package com.movies.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import java.util.Date;

@Table(name="movies")
@Entity
public class Movies {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Integer id;
	
	@Column(length=100, nullable=false)
	private String title;
	
	@Lob
	private String description;
	
	@Column(name="rating")
	private Float rating;
	
	@Column(nullable=false)
	private String image;
	
//	@CreationTimestamp
	@Column(updatable=false, name="created_at")
	private Date created_at;
	
//	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updated_at;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getCreated_at() {
		return created_at;
	}
	
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

}
