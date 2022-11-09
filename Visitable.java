/*
 * General visitable interface
 */
public interface Visitable {
	public void accept(UserTypeVisitor visitor);
}
