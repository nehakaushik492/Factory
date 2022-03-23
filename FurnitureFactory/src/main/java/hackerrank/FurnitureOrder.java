package hackerrank;

import java.util.HashMap;

public class FurnitureOrder implements FurnitureOrderInterface {
    
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
	private HashMap<Furniture, Integer> furnitureMap;
    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
    	furnitureMap = new HashMap<Furniture, Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
    	int count=0;
    	if(furnitureMap.containsKey(type)){
    		count = furnitureMap.get(type);
    	}
    	furnitureMap.put(type, furnitureCount + count );
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return new HashMap<Furniture, Integer>(furnitureMap);
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
    	if(!furnitureMap.isEmpty()){
    		return furnitureMap.entrySet().stream().map(obj -> obj.getKey().cost() * obj.getValue())
    				.collect(Collectors.toList()).stream().reduce(Float::sum).get();
    	}
        return 0.0f;
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
    	if(furnitureMap.containsKey(type)){
    		return furnitureMap.get(type);
    	}
        return 0;
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
    	if(furnitureMap.containsKey(type)){
    		return furnitureMap.get(type) * type.cost();
    	}
        return 0.0f;
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
    	if(!furnitureMap.isEmpty()){
    		return furnitureMap.entrySet().stream().map(obj-> obj.getValue()).collect(Collectors.toList())
    				.stream().reduce(Integer:: sum).get();
    		
    	}
        return 0;
    }

}
