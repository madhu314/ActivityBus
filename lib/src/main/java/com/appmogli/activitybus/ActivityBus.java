package com.appmogli.activitybus;

/**
 * Created by Madhu on 12/27/13.
 */
public interface ActivityBus {

    public static interface PostEventListener {
        public void onEvent(String name, Object data);
    }

    /**
     * @param name Name of this event
     * @param data data associated with this event
     */
    public void post(String name, Object data);

    /**
     * @param name
     * @param listener
     */
    public void subscribeForEvent(String name, PostEventListener listener);

    /**
     * @param name
     * @param listener
     */
    public void unsubscribeForEvent(String name, PostEventListener listener);

    /**
     * Unsubscribe all the registered subscribers
     */
    public void unsubscribeAll();
}
