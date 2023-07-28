import java.util.Scanner;

public class AdventureGame {
    private static Room currentRoom;
    private static boolean isGameOver;

    public static void main(String[] args) {
        initializeGame();
        while (!isGameOver) {
            displayCurrentRoom();
            handleInput();
        }
        System.out.println("Game Over!");
    }

    private static void initializeGame() {
        // Create rooms and set their connections
        Room startRoom = new Room("Start Room");
        Room secondRoom = new Room("Second Room");
        Room thirdRoom = new Room("Third Room");
        
        startRoom.setExit("east", secondRoom);
        secondRoom.setExit("west", startRoom);
        secondRoom.setExit("east", thirdRoom);
        thirdRoom.setExit("west", secondRoom);

        // Set the starting room
        currentRoom = startRoom;
    }

    private static void displayCurrentRoom() {
        System.out.println("You are in the " + currentRoom.getName());
        System.out.println("Exits: " + currentRoom.getExits());
    }

    private static void handleInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your command: ");
        String command = scanner.nextLine().trim().toLowerCase();

        if (command.equals("quit")) {
            isGameOver = true;
        } else if (command.equals("help")) {
            displayHelp();
        } else if (command.equals("look")) {
            System.out.println(currentRoom.getDescription());
        } else if (command.startsWith("go ")) {
            String direction = command.substring(3);
            go(direction);
        } else {
            System.out.println("Invalid command. Type 'help' for available commands.");
        }
    }

    private static void go(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            System.out.println("You can't go that way.");
        } else {
            currentRoom = nextRoom;
        }
    }

    private static void displayHelp() {
        System.out.println("Available commands:");
        System.out.println("go <direction>: Move to the specified direction.");
        System.out.println("look: Get a description of the current room.");
        System.out.println("help: Display available commands.");
        System.out.println("quit: End the game.");
    }
}
