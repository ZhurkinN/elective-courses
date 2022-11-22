package ru.rsreu.electivecourses.command;

import ru.rsreu.electivecourses.command.enums.ActionType;

import java.util.HashMap;
import java.util.Map;

public class CommandResult {

    private String view;
    private ActionType commandAction;
    private Map<String, Object> attributes = new HashMap<>();

    public CommandResult(String view, ActionType commandAction) {
        this.view = view;
        this.commandAction = commandAction;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public ActionType getCommandAction() {
        return commandAction;
    }

    public void setCommandAction(ActionType commandAction) {
        this.commandAction = commandAction;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}
