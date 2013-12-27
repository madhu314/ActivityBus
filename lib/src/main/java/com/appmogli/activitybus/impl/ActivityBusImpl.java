package com.appmogli.activitybus.impl;

import com.appmogli.activitybus.ActivityBus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Madhu on 12/27/13.
 */
public class ActivityBusImpl implements ActivityBus {

    public Map<String, Set<PostEventListener>> subscribers = new HashMap<String, Set<PostEventListener>>();

    @Override
    public void post(String name, Object data) {
        if (subscribers.containsKey(name)) {
            for (PostEventListener listener : subscribers.get(name)) {
                listener.onEvent(name, data);
            }
        }
    }

    @Override
    public void subscribeForEvent(String name, PostEventListener listener) {
        if (subscribers.containsKey(name)) {
            subscribers.get(name).add(listener);
        } else {
            Set<PostEventListener> listenerSet = new HashSet<PostEventListener>();
            listenerSet.add(listener);
            subscribers.put(name, listenerSet);
        }
    }

    @Override
    public void unsubscribeForEvent(String name, PostEventListener listener) {
        if (subscribers.containsKey(name)) {
            subscribers.get(name).remove(listener);
        }
    }

    @Override
    public void unsubscribeAll() {
        for (Set<PostEventListener> listeners : subscribers.values()) {
            listeners.clear();
        }
        subscribers.clear();
    }

}
