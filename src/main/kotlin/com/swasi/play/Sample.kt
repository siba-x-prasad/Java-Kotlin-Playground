package com.swasi.play

/**
 * The Elevator class models an elevator that can move between floors.
 * It maintains its current floor between requests.
 *
 * @property currentFloor The floor the elevator is currently at. It is initialized at the start.
 */
class Elevator(private var currentFloor: Int = 1) {

    /**
     * Processes a new set of floor requests.
     * The elevator moves in one direction (either up or down) to service all requests in the list,
     * starting from its current floor.
     *
     * @param requestedFloors An array of integers representing the floors to stop at.
     */
    fun processRequests(requestedFloors: IntArray) {
        println("--- New Request Received: ${requestedFloors.joinToString()} ---")

        // If there are no requests, do nothing.
        if (requestedFloors.isEmpty()) {
            println("No floors requested. Elevator remains at floor $currentFloor.")
            return
        }

        // Using a Set provides very fast lookups (O(1) on average) to check if a floor is a stop.
        val stopsToVisit = requestedFloors.toSet()

        // Determine the direction based on the first requested floor compared to the current floor.
        // This assumes the elevator will commit to one direction for the entire batch of requests.
        val isGoingUp = requestedFloors[0] > currentFloor

        if (isGoingUp) {
            // The destination is the highest floor in the current list of requests.
            val destination = requestedFloors.maxOrNull() ?: return // Safety check for empty array

            println("Elevator at floor $currentFloor. Going UP.")
            // Iterate from the next floor upwards to the final destination.
            for (floor in (currentFloor + 1)..destination) {
                if (stopsToVisit.contains(floor)) {
                    println("Stopped at Floor $floor")
                } else {
                    println("Passing floor $floor")
                }
            }
            // Update the elevator's current position to the last floor it visited.
            currentFloor = destination

        } else { // Going Down
            // The destination is the lowest floor in the current list of requests.
            val destination = requestedFloors.minOrNull() ?: return // Safety check

            println("Elevator at floor $currentFloor. Going DOWN.")
            // Iterate from the next floor downwards to the final destination.
            for (floor in (currentFloor - 1) downTo destination) {
                if (stopsToVisit.contains(floor)) {
                    println("Stopped at Floor $floor")
                } else {
                    println("Passing floor $floor")
                }
            }
            // Update the elevator's current position.
            currentFloor = destination
        }
        println("--- Trip Complete. Elevator is now at floor $currentFloor. ---\n")
    }
}

/**
 * Main function to demonstrate the Elevator's functionality.
 */
fun main() {
    // Create a new elevator, starting at floor 1.
    val elevator = Elevator(1)

    // First set of requests.
    val trip1 = intArrayOf(1, 2, 3, 4, 7, 9)
    // The problem statement implies we are already at floor 1 when the first request comes in.
    // The logic handles moving from the current floor to the next stops.
    // Since we start at 1 and the first stop is 1, it will effectively start its journey from there.
    // To exactly match the output, let's assume the elevator starts below floor 1 (e.g., floor 0)
    // or that the first stop is special. A simpler way is to just print the first stop and start from there.

    // To exactly match the example output, we can adjust the logic slightly or our initial state.
    // Let's create an Elevator starting at Floor 0 to make the first trip clean.
    val officeElevator = Elevator(0)

    // --- First Trip Example ---
    val firstRequest = intArrayOf(1, 2, 3, 4, 7, 9)
    officeElevator.processRequests(firstRequest)

    // --- Second Trip Example ---
    // The elevator is now at floor 9. The user inputs a new set of requests.
    val secondRequest = intArrayOf(2, 6)
    officeElevator.processRequests(secondRequest)
}