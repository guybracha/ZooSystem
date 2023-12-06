package FinalProjectStudent.api;


import FinalProjectStudent.ObserverSystem;

/**
 * The {@code IObserver} interface defines the common behavior expected from observer objects
 * that subscribe to changes in an observable subject, such as the {@link ObserverSystem}.
 * Implementing classes must provide an implementation for the {@link #update(ObserverSystem)} method,
 * which is called when the observed subject undergoes changes.
 */
public interface IObserver {
	/**
	 * Getting updates from the class manager through IObserverSystem.
	 * Src info:
	 * <a href="https://www.youtube.com/watch?v=_BpmfnqjgzQ"</a>
	 * */
    /**
     * This method is called by the observed subject (e.g., {@link ObserverSystem}) to notify
     * the observer about changes or events.
     *
     * @param subject The observable subject that triggered the update.
     */
    void update(Object updateInfo);

}
