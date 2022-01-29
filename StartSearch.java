import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class represents a search that is performed on each map file to determine the proper route option.
 * @author Jai Sharma
 */

public class StartSearch {
	
	/*
	 * Creating a variable called map of type Map to be used in the object initialization within the constructor below.
	 */
	private Map map;

	
	
	/**
	 * Constructor creates and initializes the map object with the given string variable mapName.
	 * @param mapName is a string used to initialize the map object.
	 * @throws InvalidMapException checks if the map is valid.
	 * @throws FileNotFoundException ensures that there is a file we are performing the search on.
	 * @throws IOException makes sure there are no errors regarding the input and output of map.
	 */
	public StartSearch(String mapName) throws InvalidMapException, FileNotFoundException, IOException {

		try {
			map = new Map(mapName);
		} catch (InvalidMapException e) {
			System.out.println("The map is not in the correct format.");
		} catch (FileNotFoundException e) {
			System.out.println("Given input file does not exist " + mapName);
		} catch (IOException e) {
			System.out.println("Problems with input and output format");
		}
	}

	
	
	/**
	 * Public method that determines the best cell should be added to the path after the current one based on certain conditions outlined in the method.
	 * @param currentCell represents the cell we are currently in.
	 * @return null to satisfy the compiler.
	 * @throws InvalidNeighbourIndexException if the cell doesn't have a valid neighbour.
	 */
	public MapCell bestCell(MapCell currentCell) throws InvalidNeighbourIndexException {

		/*
		 * Creating a mapCell array of length 4 that will be used to store the neighbours at each index from 0-3.
		 */
		MapCell[] neighbour = new MapCell[4];

		try {
			
			/*
			 * Creating and setting the neighbours indices based on current cell's position.
			 */
			for (int i = 0; i <= 3; i++) {
				neighbour[i] = currentCell.getNeighbour(i);
			}

			for (int i = 0; i <= 3; i++) {
				neighbour[i] = currentCell.getNeighbour(i);
			}

			/*
			 * If the current cell is the beginning of the map it ensures there is a path it can continue on and checks certain conditions from the beginning.
			 */
			if (currentCell.isStart() == true) {
				/*
				 * Checks conditions for all neighbours, will do this multiple times for all the conditions below that have the current cell as the start one.
				 */
				for (int i = 0; i <= 3; i++) {
					
					/*
					 * From here on out will always check to make sure the neighbour is not null for all the conditions below that have the current cell as the start one, so the path can continue there.
					 */
					if (neighbour[i] != null) {
						
						/*
						 * From a start cell if the neighbour is the destination cell and not a marked cell, the path can continue there.
						 */
						if (neighbour[i].isExit() == true && neighbour[i].isMarked() == false) {
							return neighbour[i];
						}
					}
				}

				for (int i = 0; i <= 3; i++) {
					if (neighbour[i] != null) {
						
						/*
						 * From a start cell if the neighbour is a donut cell and is not marked, the path can continue there.
						 */
						if (neighbour[i].isDonut() == true && neighbour[i].isMarked() == false) {
							return neighbour[i];
						}
					}
				}
				
				
				for (int i = 0; i <= 3; i++) {
					if (neighbour[i] != null) {
						/*
						 * From a start cell if the neighbour is a cross path and is not marked, the path can continue there.
						 */
						if (neighbour[i].isCrossPath() == true && neighbour[i].isMarked() == false) {
							return neighbour[i];
						}
					}
				}

				for (int i = 0; i <= 3; i++) {
					if (neighbour[i] != null) {
						/*
						 * From a start cell if the neighbour is a vertical or horizontal cell and not a marked cell, the path can continue there.
						 */
						if ((neighbour[i].isVerticalPath() == true || neighbour[i].isHorizontalPath() == true) && neighbour[i].isMarked() == false) {
							return neighbour[i];
						}
					}
				}
			/*
			 * Now checks various conditions if the current cell is not a start cell but is rather a horizontal or vertical path, to ensure the path continues properly.
			 */
			} else if (currentCell.isHorizontalPath() || currentCell.isVerticalPath()) {
				
				/*
				 * The next 4 if statements check If the current cell is a vertical or horizontal path, its neighbour at each index is not null, its neighbour at each is the exit cell, and its neighbour at each index isn't marked, to ensure the path can continue there.
				 */
				if ((currentCell.isVerticalPath()) && (neighbour[0] != null) && (neighbour[0].isExit())
						&& (neighbour[0].isMarked() == false)) {
					return neighbour[0];
				}
				
				
				if ((currentCell.isHorizontalPath()) && (neighbour[1] != null) && (neighbour[1].isExit())
						&& (neighbour[1].isMarked() == false)) {
					return neighbour[1];
				}
				
				
				if ((currentCell.isVerticalPath()) && (neighbour[2] != null) && (neighbour[2].isExit())
						&& (neighbour[2].isMarked() == false)) {
					return neighbour[2];
				}

				
				if ((currentCell.isHorizontalPath()) && (neighbour[3] != null) && (neighbour[3].isExit())
						&& (neighbour[3].isMarked() == false)) {
					return neighbour[3];
				}

				/*
				 * The next 4 if statements check If the current cell is a vertical or horizontal path, its neighbour at each index is not null, its neighbour at each is a donut cell, and its neighbour at each index isn't marked, to ensure the path can continue there.
				 */
				if ((currentCell.isVerticalPath()) && (neighbour[0] != null) && (neighbour[0].isDonut())
						&& (neighbour[0].isMarked() == false)) {
					return neighbour[0];
				}
				
				
				if ((currentCell.isHorizontalPath()) && (neighbour[1] != null) && (neighbour[1].isDonut())
						&& (neighbour[1].isMarked() == false)) {
					return neighbour[1];
				}

				
				if ((currentCell.isVerticalPath()) && (neighbour[2] != null) && (neighbour[2].isDonut())
						&& (neighbour[2].isMarked() == false)) {
					return neighbour[2];
				}

				
				if ((currentCell.isHorizontalPath()) && (neighbour[3] != null) && (neighbour[3].isDonut())
						&& (neighbour[3].isMarked() == false)) {
					return neighbour[3];
				}

				
				/*
				 * The next 4 if statements check If the current cell is a vertical or horizontal path, its neighbour at each index is not null, its neighbour at each is a cross path cell, and its neighbour at each index isn't marked, to ensure the path can continue there.
				 */
				if ((currentCell.isVerticalPath()) && (neighbour[0] != null) && (neighbour[0].isCrossPath())
						&& (neighbour[0].isMarked() == false)) {
					return neighbour[0];
				}

				if ((currentCell.isHorizontalPath()) && (neighbour[1] != null) && (neighbour[1].isCrossPath())
						&& (neighbour[1].isMarked() == false)) {
					return neighbour[1];
				}

				if ((currentCell.isVerticalPath()) && (neighbour[2] != null) && (neighbour[2].isCrossPath())
						&& (neighbour[2].isMarked() == false)) {
					return neighbour[2];
				}

				if ((currentCell.isHorizontalPath()) && (neighbour[3] != null) && (neighbour[3].isCrossPath())
						&& (neighbour[3].isMarked() == false)) {
					return neighbour[3];
				}

				/*
				 * The next 4 if statements check to make sure the neighbour at each index isn't null, sees if the neighbour at each index is a horizontal path, and the neighbour at each index isn't marked, to ensure the path can continue there.
				 */
				if ((neighbour[0] != null) && (neighbour[0].isHorizontalPath()) && (neighbour[0].isMarked() == false)) {
					return neighbour[0];
				}

				if ((neighbour[1] != null) && (neighbour[1].isHorizontalPath()) && (neighbour[1].isMarked() == false)) {
					return neighbour[1];
				}

				if ((neighbour[2] != null) && (neighbour[2].isHorizontalPath()) && (neighbour[2].isMarked() == false)) {
					return neighbour[2];
				}

				if ((neighbour[3] != null) && (neighbour[3].isHorizontalPath()) && (neighbour[3].isMarked() == false)) {
					return neighbour[3];
				}

				/*
				 * The next 4 if statements check to make sure the neighbour at each index isn't null, sees if the neighbour at each index is a vertical path, and the neighbour at each index isn't marked, to ensure the path can continue there.
				 */
				if ((neighbour[0] != null) && (neighbour[0].isVerticalPath()) && (neighbour[0].isMarked() == false)) {
					return neighbour[0];
				}

				if ((neighbour[1] != null) && (neighbour[1].isVerticalPath()) && (neighbour[1].isMarked() == false)) {
					return neighbour[1];
				}

				if ((neighbour[2] != null) && (neighbour[2].isVerticalPath()) && (neighbour[2].isMarked() == false)) {
					return neighbour[2];
				}

				if ((neighbour[3] != null) && (neighbour[3].isVerticalPath()) && (neighbour[3].isMarked() == false)) {
					return neighbour[3];
				}

			} else {
				
				/*
				 * If the current cell isn't the start cell or a horizontal or vertical path cell.
				 */

				/*
				 * Goes through all 4 neighbours and checks if the neighbour is a covid cell, if it is, it will return null to indicate the path cannot continue there.
				 */
				for (int i = 0; i <= 3; i++) {
					if ((neighbour[i] != null) && (neighbour[i].isCovid() == true)
							&& (neighbour[i].isMarked() == false)) {
						return null;
					}
				}

				/*
				 * Goes through all 4 neighbours and checks if the neighbour is an exit cell, if it is, it will go to the exit cell to indicate the path can continue there.
				 */
				for (int i = 0; i <= 3; i++) {
					if ((neighbour[i] != null) && (neighbour[i].isExit() == true)
							&& (neighbour[i].isMarked() == false)) {
						return neighbour[i];
					}
				}

				/*
				 * Goes through all 4 neighbours and checks if the neighbour is a donut cell, if it is, it will go to the donut cell to indicate the path can continue there.
				 */
				for (int i = 0; i <= 3; i++) {
					if ((neighbour[i] != null) && (neighbour[i].isDonut() == true)
							&& (neighbour[i].isMarked() == false)) {
						return neighbour[i];
					}
				}

				/*
				 * Goes through all 4 neighbours and checks if the neighbour is a cross path cell, if it is, it will go to the cross path cell to indicate the path can continue there.
				 */
				for (int i = 0; i <= 3; i++) {
					if ((neighbour[i] != null) && (neighbour[i].isCrossPath() == true)
							&& (neighbour[i].isMarked() == false)) {
						return neighbour[i];
					}
				}

				/*
				 * The next 4 if statements check if the current cell is a cross path or a donut cell and sees if one of its neighbours is a vertical or horizontal path, and indicates that the path can continue there if those conditions are true.
				 */
				if ((currentCell.isCrossPath() || currentCell.isDonut()) && (neighbour[0] != null)
						&& (neighbour[0].isVerticalPath() == true) && (neighbour[0].isMarked() == false)) {
					return neighbour[0];
				}

				if ((currentCell.isCrossPath() || currentCell.isDonut()) && (neighbour[1] != null)
						&& (neighbour[1].isHorizontalPath() == true) && (neighbour[1].isMarked() == false)) {
					return neighbour[1];
				}

				if ((currentCell.isCrossPath() || currentCell.isDonut()) && (neighbour[2] != null)
						&& (neighbour[2].isVerticalPath() == true) && (neighbour[2].isMarked() == false)) {
					return neighbour[2];
				}

				if ((currentCell.isCrossPath() || currentCell.isDonut()) && (neighbour[3] != null)
						&& (neighbour[3].isHorizontalPath() == true) && (neighbour[3].isMarked() == false)) {
					return neighbour[3];
				}

			}

		} catch (InvalidNeighbourIndexException e) {
			System.out.println("The map is not in the correct format.");

		}

		return null;
	}
	

	/**
	 * Public method that searches for a valid path while making sure all the conditions from bestCell() are followed.
	 * @return actionString because it contains the entire sequence of visited cells.
	 */
	public String findPath()  {

		/*
		 * Creating and initializing an ArrayStack.
		 */
		ArrayStack<MapCell> travelStack = new ArrayStack<MapCell>();

		/*
		 * Creating an empty actionString variable that will eventually hold the sequence of visited cells.
		 */
		String actionString = "";

		/*
		 * Boolean variable to indicate whether or not the destination was reached.
		 */
		boolean statusFlag = false;

		/*
		 * Creating and pushing the starting cell into the stack and marking the cell as inStack/
		 */
		MapCell startingCell = map.getStart();
		startingCell.markInitial();

		travelStack.push(startingCell);

		/*
		 * Creating a variable for the energy level and initalzing it at 10, which is the base energy for someone who starts on a path.
		 */
		int energyLevel = 10;

		
		/*
		 * While the stack isn't empty and the destination wasn't reached.
		 */
		while ((!travelStack.isEmpty()) && (statusFlag == false)) {
			
			/*
			 * Getting the current cell.
			 */
			MapCell peekFirst;
	
			peekFirst = travelStack.peek();
			MapCell current = bestCell(peekFirst);
			
			/*
			 * Updating actionString to contain the content of the cell being visited.
			 */
			actionString = actionString + peekFirst + "-";
			

			/*
			 * If a next cell exists and the energy level is above 0.
			 */
			if ((current != null) && (energyLevel > 0)) {
				/*
				 * Checking if the next cell is the destination and if it is updatign statusFalg to true.
				 */
				if (current.isExit() == true) {

					actionString = actionString + "E" + (energyLevel - 1);

					statusFlag = true;
				}

				/*
				 * Checking if the next cell is a donut cell and if it is increasing the energy level by 3.
				 */
				if (current.isDonut() == true) {
					energyLevel += 3;
				}

				/*
				 * Pushing the neighbouring cell into the stack and marking it as inStack.
				 */
				travelStack.push(current);
				current.markInStack();
				
				/*
				 * Decreasing the energy level by 1 due to the movement.
				 */
				energyLevel = energyLevel - 1;
				
			} else {

				/*
				 * Popping the top cell out of the stack and marking it as out of the stack.
				 */
				MapCell firstPop;
				firstPop = travelStack.pop();
				firstPop.markOutStack();

				/*
				 * If that top cell is a donut cell, decreasing the energy level by 3
				 */
				if (firstPop.isDonut() == true) {
					energyLevel = energyLevel - 3;
				}

				/*
				 * If that top cell is not the starting point, increasing the energy level by 1 
				 */
				if (firstPop.isStart() != true) {
					energyLevel = energyLevel + 1;
				}
			}

		}

		if (statusFlag == false) {
			actionString = actionString + "E" + (energyLevel);
		}

		while (!travelStack.isEmpty()) {
			/*
			 * Popping the top cell from the stack and marking it as out of stack.
			 */
			MapCell anotherPop;
			anotherPop = travelStack.pop();
			anotherPop.markOutStack();
		}
		

		return actionString;

	}


	/**
	 * Method that starts the program and used to initialize the startSearch object so an input file can be passed.
	 * @param args arguments.
	 * @throws InvalidMapException checks if the map is valid.
	 * @throws FileNotFoundException ensures that there is a file we are performing the search on.
	 * @throws IOException makes sure there are no errors regarding the input and output of map.
	 */
	public static void main(String[] args) throws InvalidMapException, FileNotFoundException, IOException {

		try {

			/*
			 * If there are no arguments, telling the user to enter an file name.
			 */
			if (args.length < 1) {
				System.out.println("You must provide the name of the input file");
			}
			
			String mapFile = args[0];

			/*
			 * Using argument to initialize a startSearch object.
			 */
			StartSearch startSearchObject = new StartSearch(mapFile);

			/*
			 * Calling the findPath method on the start search object.
			 */
			startSearchObject.findPath();

		} catch (InvalidMapException e) {
			System.out.println("The map is not in the correct format.");
		} catch (FileNotFoundException e) {
			System.out.println("Given input file does not exist ");
		} catch (IOException e) {
			System.out.println("Problems with input and output format");
		}

	}

}
