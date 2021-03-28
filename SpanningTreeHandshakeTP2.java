import visidia.simulation.SimulationConstants;
import visidia.simulation.process.algorithm.LC0_Algorithm;
import visidia.simulation.process.edgestate.MarkedState;

public class SpanningTreeHandshakeTP2 extends LC0_Algorithm {

	String etatsVoisins[];
	int fatherDoor = -1;
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Spanning tree algorithm using LCO.\n"+
				"Rule: N---A ---> A---M\n A---M ---> F---A";
	}
	
	@Override
	protected void beforeStart() {
		// TODO Auto-generated method stub
		etatsVoisins = new String[vertex.getDegree()];
		for(int i =0; i<vertex.getDegree(); i++) {
			etatsVoisins[i] = "N";
		}
		this.setLocalProperty("compteur",1);
		this.putProperty("Affichage", this.getLocalProperty("compteur"), SimulationConstants.PropertyStatus.DISPLAYED);
		this.setLocalProperty("label", vertex.getLabel());
	}

	@Override
	protected void onStarCenter() {
		// TODO Auto-generated method stub
		etatsVoisins[this.neighborDoor] = this.getNeighborProperty("label").toString();
		if(getLocalProperty("label").equals("N") && getNeighborProperty("label").equals("A")) {
			setNeighborProperty("label", "M");
			setLocalProperty("label", "A");
			setDoorState(new MarkedState(true), neighborDoor);
			fatherDoor = neighborDoor;
			etatsVoisins[this.neighborDoor] = "M";
		}
		else if(getLocalProperty("label").equals("A") &&
				getNeighborProperty("label").equals("M") &&
				fatherDoor == this.neighborDoor
				) {
			boolean hasN = false;
			for(int i = 0; i< etatsVoisins.length ; i++) {
				if(etatsVoisins[i].equals("N")) {
					hasN = true;
					break;
				}
			}
			if(!hasN) {
				setNeighborProperty("label", "A");
				setLocalProperty("label", "F");
				
				int c = (int)this.getLocalProperty("compteur")+(int)this.getNeighborProperty("compteur");
				this.setNeighborProperty("compteur", c);
				
			}
			
		}
		
		this.putProperty("Affichage", this.getLocalProperty("compteur") , SimulationConstants.PropertyStatus.DISPLAYED);
	}

	@Override
	public Object clone() {
		// TODO Auto-generated method stub
		return new SpanningTreeHandshakeTP2();
	}

}
