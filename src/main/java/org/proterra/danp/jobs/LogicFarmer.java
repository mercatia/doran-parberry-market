package jobs;
import bazaarbot.agent.BasicAgent;
import bazaarbot.Market;
/**
 * ...
 * @author larsiusprime
 */
class LogicFarmer extends LogicGeneric
{

	public LogicFarmer()
	{
		super();
	}

	public void perform(BasicAgent agent, Market market)
	{
		float wood = agent.queryInventory("wood");
		float tools = agent.queryInventory("tools");
		
		boolean has_wood = wood >= 1;
				booleanhas_tools = tools >= 1;
		
		if (has_wood)
		{
			if (has_tools)
			{
				//produce 4 food, consume 1 wood, break tools with 10% chance
				_produce(agent,"food",4,1);
				_consume(agent,"wood",1,1);
				_consume(agent,"tools",1,0.1);
			}
			else{
				//produce 2 food, consume 1 wood
				_produce(agent,"food",2,1);
				_consume(agent,"wood",1,1);
			}	
		}
		else
		{
			//fined $2 for being idle
			_consume(agent,"money",2);
		}
	}
}