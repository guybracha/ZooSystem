package FinalProjectStudent;

import FinalProjectStudent.api.IObserver;
import FinalProjectStudent.api.IObserverSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code ObserverSystem} class implements the {@link IObserverSystem} interface
 * to manage a list of observers and notify them based on different notification types.
 * It supports the observer design pattern to notify registered observers of system events.
 */
public class ObserverSystem implements IObserverSystem {
    /** The list of observers registered with the observer system. */
    private List<IObserver> observers;

    /**
     * Constant representing the TASK_MODE notification type.
     */    
    public static final int TASK_MODE = 1;
    
    /**
     * Constructs a new {@code ObserverSystem} with an empty list of observers.
     */
    public ObserverSystem() {
        this.observers = new ArrayList<>();
    }

    /**
     * Adds an observer to the list of registered observers.
     *
     * @param observer The observer to be added.
     */
    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from the list of registered observers.
     *
     * @param observer The observer to be removed.
     */
    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all registered observers based on the specified notification type.
     *
     * @param notificationType The type of notification to be sent.
     *                         Constants such as {@code TASK_MODE} can be used.
     */
    @Override
    public void update(String notificationType) {
        switch (notificationType) {
            case IObserverSystem.TASK_MODE:
                System.out.println("ObserverSystem: Received TASK_MODE notification");
                // Perform actions related to TASK_MODE
                break;
            // Add more cases for other notification types, if needed
            default:
                System.out.println("ObserverSystem: Received unknown notification type");
        }
    }
    
    /**
     * Notifies all registered observers with additional update information.
     *
     * @param updateInfo The additional information to be sent to observers.
     */
    public void notifyObservers(Object updateInfo) {
        for (IObserver observer : observers) {
            observer.update(this);
        }
    }
    /**
     * Notifies all registered observers based on the specified mode.
     * This method is part of the {@link IObserverSystem} interface.
     *
     * @param mode The mode for notification.
     */
	@Override
	public void notifyObservers(int mode) {
		// TODO Auto-generated method stub
		
	}
}
