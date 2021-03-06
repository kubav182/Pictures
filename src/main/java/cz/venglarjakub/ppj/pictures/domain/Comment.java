
package cz.venglarjakub.ppj.pictures.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author kuba
 */
@Document(collection = "comment")
@Entity
@Table(name = "comment")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@jsonId", scope = Comment.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    @org.springframework.data.annotation.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private BigInteger id;
    @Basic(optional = false)
    @Column(name = "comment", nullable = false, length = 100)
    private String comment;
    @Basic(optional = false)
    @Column(name = "likes", nullable = false)
    private int likes;
    @Basic(optional = false)
    @Column(name = "dislikes", nullable = false)
    private int dislikes;
    @DBRef
    @JoinColumn(name = "Picture_id", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Picture picture;
    @DBRef
    @JoinColumn(name = "Author_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Author author;

    public Comment() {
    }

    public Comment(BigInteger id) {
        this.id = id;
    }

    public Comment(BigInteger id, String comment, int like, int dislike) {
        this.id = id;
        this.comment = comment;
        this.likes = like;
        this.dislikes = dislike;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
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

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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
