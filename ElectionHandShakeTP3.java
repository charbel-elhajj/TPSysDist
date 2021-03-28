import visidia.simulation.SimulationConstants;
import visidia.simulation.process.algorithm.LC0_Algorithm;
import visidia.simulation.process.edgestate.MarkedState;

/**
 *
 * @author Charbel
 */
public class ElectionHandShakeTP3 extends LC0_Algorithm{
	String etatsVoisins[];
	int fatherDoor;

    @Override
    public String getDescription() {
        return "Spanning tree algorithm using LC0 .\n Rule: A---N ---> A---A"
        		+ "\n";
        
    }

    @Override
    protected void beforeStart() {
    	
        this.setLocalProperty("label", vertex.getLabel());
        
        this.setLocalProperty("counter", vertex.getDegree());
        putProperty("Affichage", getLocalProperty("counter") ,SimulationConstants.PropertyStatus.DISPLAYED);
        
        
    }

    @Override
    protected void onStarCenter() {
    	
        if(this.getLocalProperty("label").equals("N") && 
                this.getNeighborProperty("label").equals("N")&&
                this.getLocalProperty("counter").equals(1)){
            if(this.getNeighborProperty("counter").equals(1)) {
            	this.setLocalProperty("label","E");
            	this.setNeighborProperty("label","F");
            }
            else {
            	this.setLocalProperty("label","F");
            	int counter = (int) this.getNeighborProperty("counter") - 1;
            	this.setNeighborProperty("counter", counter);
            }
            
        
        	
        }
        
        putProperty("Affichage", getLocalProperty("counter") ,SimulationConstants.PropertyStatus.DISPLAYED);
    }

    @Override
    public Object clone() {
        return new ElectionHandShakeTP3();
    }
    
   
    
}
