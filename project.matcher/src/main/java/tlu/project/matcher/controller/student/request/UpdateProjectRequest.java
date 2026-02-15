package tlu.project.matcher.controller.student.request;

import lombok.Data;

@Data
public class UpdateProjectRequest {
    private Long id;
    private String name;
    private String description;
}
