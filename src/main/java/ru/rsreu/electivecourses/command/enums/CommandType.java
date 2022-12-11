package ru.rsreu.electivecourses.command.enums;

import ru.rsreu.electivecourses.command.ShowBlockUserFormCommand;
import ru.rsreu.electivecourses.command.*;

public enum CommandType {

    LOGIN("login", LoginCommand.class),
    LOGOUT("logout", LogoutCommand.class),
    RETURN_TO_MAIN_PAGE("returnToMain", ReturnToMainPageCommand.class),
    SHOW_REGISTRATION_NEW_USER_FORM("showRegistrationNewUser", ShowRegistrationNewUserFormCommand.class),
    CREATE_NEW_USER("createNewUser", CreateUserCommand.class),
    SHOW_DELETING_USER_FORM("showDeletingUser", ShowDeletingUserFormCommand.class),
    DELETE_USER("deleteUser", DeleteUserCommand.class),
    EDIT_USER("editUser", EditUserCommand.class),
    SHOW_EDITING_USER_FORM("showEditingUser", ShowEditingUserFormCommand.class),
    SHOW_BLOCKING_USER_FORM("showBlockUser", ShowBlockUserFormCommand.class),
    BLOCK_USER("blockUser", BlockUserCommand.class),
    UNBLOCK_USER("unblockUser", UnblockUserCommand.class);

    private String commandName;
    private Class<? extends Command> commandClass;

    CommandType(String commandName, Class<? extends Command> commandClass) {
        this.commandName = commandName;
        this.commandClass = commandClass;
    }

    public static CommandType getCommandType(String commandName) {
        for (CommandType commandType : CommandType.values()) {
            if (commandType.getCommandName().equals(commandName)) {
                return commandType;
            }
        }
        return CommandType.LOGIN;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public Class<? extends Command> getCommandClass() {
        return commandClass;
    }

    public void setCommandClass(Class<? extends Command> commandClass) {
        this.commandClass = commandClass;
    }
}
