package FinalProjectStudent.api;

import FinalProjectStudent.api.IObserver;

/**
 * The {@code IObserverSystem} interface defines the common behavior expected from an observable system
 * that manages a collection of observers. Classes implementing this interface should provide concrete
 * implementations for attaching observers using {@link #attach(FinalProject.api.IObserver)}, detaching observers using
 * {@link #detach(FinalProject.api.IObserver)}, and notifying observers about events using {@link #notifyMsg(int)}.
 */
public interface IObserverSystem {
	/**
	 * Serve the Manager Class, as the subject to the Observables:
	 * the working stuff.
	 * Src info:
	 * <a href="https://www.youtube.com/watch?v=_BpmfnqjgzQ"<a/>
	 * */
    /**
     * Attach an observer to the subject.
     *
     * @param observer The observer to be attached.
     */
    void addObserver(IObserver observer);

    /**
     * Detach an observer from the subject.
     *
     * @param observer The observer to be detached.
     */
    void removeObserver(IObserver observer);

    /**
     * Notify all observers about an event.
     *
     * @param mode An integer representing the mode or type of the event.
     */
    void notifyObservers(int mode);
    
    // New method
    void update(String task);

    // Constants, if any
    String TASK_MODE = "TaskMode";

}
