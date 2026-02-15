package tlu.project.matcher.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tlu.project.matcher.controller.student.request.*;
import tlu.project.matcher.domain.Project;
import tlu.project.matcher.domain.ProjectStudent;
import tlu.project.matcher.domain.Student;
import tlu.project.matcher.domain.User;
import tlu.project.matcher.repository.jpa.ProjectRepository;
import tlu.project.matcher.repository.jpa.StudentRepository;
import tlu.project.matcher.service.ProjectService;
import tlu.project.matcher.utils.BaseResponse;
import tlu.project.matcher.utils.CustomResponse;

import java.util.Optional;

@Service
@Log4j2
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;
    private StudentRepository studentRepository;

    @Override
    public BaseResponse createProject(CreateProjectRequest request, User user) {
        CustomResponse response = new CustomResponse();
        Project project = new Project();
        project.setName(request.getName());
        project.setDescription(request.getDescription());

        Student student = studentRepository.findById(user.getId()).orElse(null);
        project.setOwner(student);
        projectRepository.save(project);
        response.setSuccess();
        return response;
    }

    @Override
    public BaseResponse updateProject(UpdateProjectRequest request) {
        CustomResponse response = new CustomResponse();
        Project project = projectRepository.findById(request.getId()).orElse(null);
        if (project == null) {
            response.setFailed();
            return response;
        }
        project.setName(request.getName());
        project.setDescription(request.getDescription());
        projectRepository.save(project);
        response.setSuccess();
        return response;
    }

    @Override
    public BaseResponse getOwnProjectList(Long userId) {
        CustomResponse response = new CustomResponse();
        response.setSuccess(projectRepository.findByOwner_Id(userId));
        return response;
    }

    @Override
    public BaseResponse addMember(AddMemberRequest request) {
        CustomResponse response = new CustomResponse();
        Student student = studentRepository.findById(request.getStudentId()).orElse(null);
        Project project = projectRepository.findById(request.getProjectId()).orElse(null);
        if (student == null || project == null) {
            response.setFailed();
            return response;
        }

        project.addStudent(student, request.getRole());
        projectRepository.save(project);
        response.setSuccess();
        return response;
    }

    @Override
    public BaseResponse modifyMember(ModifyMemberRequest request) {
        CustomResponse response = new CustomResponse();
        Student student = studentRepository.findById(request.getStudentId()).orElse(null);
        Project project = projectRepository.findById(request.getProjectId()).orElse(null);
        if (student == null || project == null) {
            response.setFailed();
            return response;
        }

        Optional<ProjectStudent> psOpt = project.getProjectStudents().stream().filter(ps -> ps.getStudent().getId().equals(request.getStudentId())).findAny();
        if (psOpt.isPresent()) {
            ProjectStudent projectStudent = psOpt.get();
            projectStudent.setScore(request.getScore());
            projectStudent.setComment(request.getComment());
            projectStudent.setRole(request.getRole());
        }
        projectRepository.save(project);
        response.setSuccess();
        return response;
    }

    @Override
    public BaseResponse deleteMember(DeleteMemberRequest request) {
        CustomResponse response = new CustomResponse();
        Student student = studentRepository.findById(request.getStudentId()).orElse(null);
        Project project = projectRepository.findById(request.getProjectId()).orElse(null);
        if (student == null || project == null) {
            response.setFailed();
            return response;
        }

        project.getProjectStudents().removeIf(ps -> ps.getStudent().getId().equals(request.getStudentId()));
        projectRepository.save(project);
        response.setSuccess();
        return response;
    }
}
