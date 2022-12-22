package ru.rsreu.electivecourses.command.enums;

import ru.rsreu.electivecourses.command.ShowLoginPageCommand;
import ru.rsreu.electivecourses.command.Command;
import ru.rsreu.electivecourses.command.LoginCommand;
import ru.rsreu.electivecourses.command.LogoutCommand;
import ru.rsreu.electivecourses.command.ReturnToMainPageCommand;
import ru.rsreu.electivecourses.command.admin.*;
import ru.rsreu.electivecourses.command.moderator.BlockUserCommand;
import ru.rsreu.electivecourses.command.moderator.ShowBlockUserFormCommand;
import ru.rsreu.electivecourses.command.moderator.UnblockUserCommand;
import ru.rsreu.electivecourses.command.student.JoinCourseCommand;
import ru.rsreu.electivecourses.command.student.LeaveCourseCommand;
import ru.rsreu.electivecourses.command.student.ShowCourseInteractionsCommand;
import ru.rsreu.electivecourses.command.teacher.*;

public enum CommandType {

    LOGIN("login", LoginCommand.class),
    SHOW_LOGIN_PAGE("showLoginPage", ShowLoginPageCommand.class),
    LOGOUT("logout", LogoutCommand.class),
    RETURN_TO_MAIN_PAGE("returnToMain", ReturnToMainPageCommand.class),
    SHOW_REGISTRATION_NEW_USER_FORM("showRegistrationNewUser", ShowCreatingUserFormCommand.class),
    CREATE_NEW_USER("createNewUser", CreateUserCommand.class),
    SHOW_DELETING_USER_FORM("showDeletingUser", ShowDeletingUserFormCommand.class),
    DELETE_USER("deleteUser", DeleteUserCommand.class),
    EDIT_USER("editUser", EditUserCommand.class),
    SHOW_EDITING_USER_FORM("showEditingUser", ShowEditingUserFormCommand.class),
    SHOW_BLOCKING_USER_FORM("showBlockUser", ShowBlockUserFormCommand.class),
    BLOCK_USER("blockUser", BlockUserCommand.class),
    UNBLOCK_USER("unblockUser", UnblockUserCommand.class),
    START_COURSE("startCourse", StartCourseCommand.class),
    SHOW_CREATING_NEW_COURSE("showCreatingNewCourse", ShowCreatingCourseFormCommand.class),
    CREATE_NEW_COURSE("createNewCourse", CreateCourseCommand.class),
    SHOW_SETTING_GRADES("showSettingGrades", ShowSettingGradesCommand.class),
    SET_FINAL_MARK("setFinalGrade", SetFinalMarkCommand.class),
    SET_INTERMEDIATE_MARK("setIntermediateGrade", SetIntermediateMarkCommand.class),
    SHOW_SETTING_ATTENDANCE("showSettingAttendance", ShowSettingAttendanceCommand.class),
    SET_ATTENDANCE("setAttendance", SetAttendanceCommand.class),
    SHOW_COURSE_INTERACTIONS("showCourseInteractions", ShowCourseInteractionsCommand.class),
    JOIN_COURSE("joinCourse", JoinCourseCommand.class),
    LEAVE_COURSE("leaveCourse", LeaveCourseCommand.class);

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
