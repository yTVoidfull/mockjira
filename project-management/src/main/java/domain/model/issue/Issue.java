package domain.model.issue;

import java.util.Objects;

public class Issue {

  String id;
  boolean isOpen;

  private Issue(String id) {
    this.id = id;
    this.isOpen = true;
  }

  public static Issue of(String id){
    return new Issue(id);
  }

  public String getId() {
    return id;
  }

  public boolean isOpen() {
    return isOpen;
  }

  public void close() {
    isOpen = false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Issue)) return false;
    Issue that = (Issue) o;
    return isOpen == that.isOpen &&
        Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, isOpen);
  }
}
