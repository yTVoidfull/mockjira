package project.management.domain.model.issue;

public interface IssueStatusModifier {

  IssueStatus invokeOn(IssueStatus status);

}
