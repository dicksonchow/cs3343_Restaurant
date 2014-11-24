package restaurant;
public interface ActionCmd extends Cmd{
	public String execute(String[] cmdParts);
}
