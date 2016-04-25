/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.venglarjakub.ppj.pictures.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author kuba
 */
@Entity
@Table(name = "picture")
public class Picture implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic(optional = false)
    @Column(name = "last_update", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Basic(optional = false)
    @Column(name = "likes", nullable = false)
    private int likes;
    @Basic(optional = false)
    @Column(name = "dislikes", nullable = false)
    private int dislikes;
    @JoinTable(name = "picture_has_tag", joinColumns = {
            @JoinColumn(name = "Picture_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "Tag_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<Tag> tagList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pictureid")
    private List<Comment> commentList;
    @JoinColumn(name = "Author_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Author authorid;

    public Picture() {
    }

    public Picture(Integer id) {
        this.id = id;
    }

    public Picture(Integer id, String name, Date lastUpdate, int likes, int dislikes) {
        this.id = id;
        this.name = name;
        this.lastUpdate = lastUpdate;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Author getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Author authorid) {
        this.authorid = authorid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Picture)) {
            return false;
        }
        Picture other = (Picture) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "cz.venglarjakub.ppj.pictures.domain.Picture[ id=" + id + " ]";
    }

}
