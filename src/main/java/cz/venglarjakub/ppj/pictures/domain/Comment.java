
package cz.venglarjakub.ppj.pictures.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author kuba
 */
@Entity
@Table(name = "comment")
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "comment", nullable = false, length = 100)
    private String comment;
    @Basic(optional = false)
    @Column(name = "likes", nullable = false)
    private int likes;
    @Basic(optional = false)
    @Column(name = "dislikes", nullable = false)
    private int dislikes;
    @JoinColumn(name = "Picture_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Picture pictureid;
    @JoinColumn(name = "Author_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Author authorid;

    public Comment() {
    }

    public Comment(Integer id) {
        this.id = id;
    }

    public Comment(Integer id, String comment, int like, int dislike) {
        this.id = id;
        this.comment = comment;
        this.likes = like;
        this.dislikes = dislike;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public Picture getPictureid() {
        return pictureid;
    }

    public void setPictureid(Picture pictureid) {
        this.pictureid = pictureid;
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
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "cz.venglarjakub.ppj.pictures.domain.Comment[ id=" + id + " ]";
    }

}
