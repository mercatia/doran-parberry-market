package org.proterra.danp.jobs;

/**

 */
public class LogicBlacksmith extends LogicGeneric
{

	public LogicBlacksmith()
	{
		super();
	}

	 public void perform(BasicAgent agent, Market market)
	{
		float food = agent.queryInventory("food");
		float metal = agent.queryInventory("metal");

		boolean has_food = food >= 1;
		boolean has_metal = metal >= 1;

		if (has_food && has_metal)
		{
			//convert all metal into tools
			_produce(agent,"tools",metal);
			_consume(agent,"metal",metal);
		}
		else
		{
			//fined $2 for being idle
			_consume(agent,"money",2);
			if (!has_food && agent.inventoryFull)
			{
				makeRoomFor(market, agent,"food",2);
			}
		}
	}

}
