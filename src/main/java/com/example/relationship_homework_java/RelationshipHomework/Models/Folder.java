package com.example.relationship_homework_java.RelationshipHomework.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "folders" )
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @JsonIgnoreProperties("folders")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false )
    private User user;

    @JsonIgnoreProperties(value = "folders")
    @OneToMany
    @JoinTable(
            name = "files_in_folders",
            joinColumns = { @JoinColumn(
                    name = "folder_id",
                    nullable = false,
                    updatable = false)
    )


}


    private List<ArrayList> files;


    public Folder(Long id, String title, User user) {


    this.title = title;
    this.user = user;
    this.files = new ArrayList<>();
    }

    public Folder() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ArrayList> getFiles() {
        return files;
    }

    public void setFiles(List<ArrayList> files) {
        this.files = files;
    }
}


