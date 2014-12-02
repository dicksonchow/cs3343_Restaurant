package restaurant;

public class CmdCost implements ListAndCalCmd{

	public String execute() {
		return Cost.getInstance().toString();
    }
		
}
