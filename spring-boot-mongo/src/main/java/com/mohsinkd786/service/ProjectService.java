package com.mohsinkd786.service;

import com.mohsinkd786.dto.Project;
import com.mohsinkd786.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> findProjects(){
        return projectRepository.findAll();
    }

    public Project createProject(Project project){
        return  projectRepository.save(project);
    }
}
