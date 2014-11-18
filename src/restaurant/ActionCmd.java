package restaurant;
public interface ActionCmd extends Cmd{
	public void execute(String[] cmdParts);
}
